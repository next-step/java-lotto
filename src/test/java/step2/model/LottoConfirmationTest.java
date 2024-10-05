package step2.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
- 일치하는 Prize가 없을 시 새로 생성한다.
- 일치하는 Prize가 있을 시 카운트를 올린다.
- matchCount가 일치한 로또 개수를 가져온다.
- 당첨번호와 비교하여 일치하는 번호의 개수를 출력한다.
- 당첨번호가 1~45범위에 포함되지 않으면 예외를 발생시킨다.
- 수익율을 내려준다.
- 당첨번호를 아직 맞춰보지 않았다면 예외를 발생시킨다.
*/
public class LottoConfirmationTest {

    @DisplayName("일치하는 Prize가 없을 시 새로 생성한다.")
    @Test
    void checkStaticsTest() {
        LottoConfirmation lottoConfirmation = new LottoConfirmation();
        lottoConfirmation.prize(3);

        assertThat(lottoConfirmation.getPrizes().get(3)).isEqualTo(1);
    }

    @DisplayName("일치하는 Prize가 있을 시 카운트를 올린다.")
    @Test
    void checkStaticsAddCountTest() {
        LottoConfirmation lottoConfirmation = new LottoConfirmation();
        lottoConfirmation.prize(3);
        lottoConfirmation.prize(3);

        assertThat(lottoConfirmation.getPrizes().get(3)).isEqualTo(2);
    }

    @DisplayName("matchCount가 일치한 로또 개수를 가져온다.")
    @Test
    void getPrizeCountTest() {
        LottoConfirmation lottoConfirmation = new LottoConfirmation();
        lottoConfirmation.prize(3);
        lottoConfirmation.prize(3);

        assertThat(lottoConfirmation.getPrize(3)).isEqualTo(2);
    }

    @DisplayName("당첨번호와 비교하여 일치하는 번호의 개수를 저장한다.")
    @Test
    void checkLottoNumTest() {
        Lotto lotto = new Lotto();
        lotto.addLotto(List.of(1, 2, 3, 4, 5, 6));

        LottoConfirmation lottoConfirmation = new LottoConfirmation();

        lottoConfirmation.checkPrizeNum(lotto, "1,2,3,6,8,9");

        assertThat(lottoConfirmation.getPrize(4)).isEqualTo(1);
    }

    @DisplayName("당첨번호가 1~45범위에 포함되지 않으면 예외를 발생시킨다.")
    @Test
    void checkLottoNumThrowExceptionTest() {
        LottoConfirmation lottoConfirmation = new LottoConfirmation();
        Lotto lotto = new Lotto();

        assertThatThrownBy(() -> lottoConfirmation.checkPrizeNum(lotto, "1,2,3,6,8,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호는 1~45범위안에 포함되야 합니다.");
    }

    @DisplayName("수익율을 내려준다.")
    @Test
    void rateOfReturnTest() {
        Lotto lotto = new Lotto();
        lotto.addLotto(List.of(1, 2, 3, 4, 5, 6));

        LottoConfirmation lottoConfirmation = new LottoConfirmation();

        lottoConfirmation.checkPrizeNum(lotto, "1,2,3,7,8,9");

        assertThat(lottoConfirmation.rateOfReturn()).isEqualTo(5.0);
    }

    @DisplayName("손해율을 내려줄시 아직 당첨번호를 맞춰보지 않았다면 예외를 발생시킨다.")
    @Test
    void rateOfReturnThrowExceptionTest() {
        Lotto lotto = new Lotto();
        lotto.addLotto(List.of(1, 2, 3, 4, 5, 6));

        LottoConfirmation lottoConfirmation = new LottoConfirmation();

        assertThatThrownBy(lottoConfirmation::rateOfReturn)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 당첨번호를 맞춰보지 않았습니다.");
    }
}
