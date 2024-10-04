package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.enums.ExceptionMessage;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
- 당첨번호를 입력받는다.
- 당첨번호와 비교하여 일치하는 번호의 개수를 출력한다.
- 당첨번호가 1~45범위에 포함되지 않으면 예외를 발생시킨다.
- 수익율을 내려준다.
- 당첨번호를 아직 맞춰보지 않았다면 예외를 발생시킨다.
*/
public class LottoTest {

    @DisplayName("당첨번호를 입력받는다.")
    @Test
    void addLottoNumTest() {
        Lotto lotto = new Lotto(1000);
        lotto.addLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotto.addLotto(Arrays.asList(7, 8, 9, 10, 11, 12));

        assertThat(lotto.getLottos())
                .containsExactly(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(7, 8, 9, 10, 11, 12)
                );
    }

    @DisplayName("당첨번호와 비교하여 일치하는 번호의 개수를 저장한다.")
    @Test
    void checkLottoNumTest() {
        Lotto lotto = new Lotto(1000);
        lotto.addLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        lotto.checkPrizeNum("1,2,3,6,8,9");
        PrizeStatics prizeStatics = lotto.getPrizeStatics();

        assertThat(prizeStatics.getPrize(4)).isEqualTo(1);
    }

    @DisplayName("당첨번호가 1~45범위에 포함되지 않으면 예외를 발생시킨다.")
    @Test
    void checkLottoNumThrowExceptionTest() {
        Lotto lotto = new Lotto(1000);

        assertThatThrownBy(() -> lotto.checkPrizeNum("1,2,3,6,8,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.RANGE_LOTTO_NUM.message());
    }

    @DisplayName("수익율을 내려준다.")
    @Test
    void rateOfReturnTest() {
        Lotto lotto = new Lotto(1000);
        lotto.addLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        lotto.checkPrizeNum("1,2,3,7,8,9");

        assertThat(lotto.rateOfReturn()).isEqualTo(5.0);
    }

    @DisplayName("손해율을 내려줄시 아직 당첨번호를 맞춰보지 않았다면 예외를 발생시킨다.")
    @Test
    void rateOfReturnThrowExceptionTest() {
        Lotto lotto = new Lotto(1000);
        lotto.addLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(lotto::rateOfReturn)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_MATCH_PRIZE.message());
    }
}
