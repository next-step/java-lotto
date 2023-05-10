package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinnerLottoTest {

    @Test
    @DisplayName("보너스볼 매칭을 제외한 당첨로또 찾기 테스트")
    void findWinnerList() {

        Lotto lotto = new Lotto(List.of(LottoNumbers.of("1,2,3,4,5,6")));
        LottoNumbers winnerLottoNumbers = LottoNumbers.of("1,2,3,4,5,7");
        LottoNumber bonusNumber = LottoNumber.provideLottoNumber(11);
        WinnerLotto winnerLotto = new WinnerLotto(winnerLottoNumbers, bonusNumber);

        assertThat(winnerLotto.getPrizeList(lotto).get(0)).isEqualTo(Prize.THIRD_PLACE);
    }

    @Test
    @DisplayName("보너스볼 매칭을 포함 당첨로또 찾기 테스트")
    void findWinnerWithBonusBallList() {

        Lotto lotto = new Lotto(List.of(LottoNumbers.of("1,2,3,4,7,10")));
        LottoNumbers winnerLottoNumbers = LottoNumbers.of("1,2,3,4,5,7");
        LottoNumber bonusNumber = LottoNumber.provideLottoNumber(10);
        WinnerLotto winnerLotto = new WinnerLotto(winnerLottoNumbers, bonusNumber);

        assertThat(winnerLotto.getPrizeList(lotto).get(0)).isEqualTo(Prize.SECOND_PLACE);
    }

    @Test
    @DisplayName("보너스볼이 담청번호에 존재한다면 예외를 던진다.")
    void throwExceptionExistBonusBallIntoWinnerNumber() {

        LottoNumbers winnerLottoNumbers = LottoNumbers.of("1,2,3,4,5,10");
        LottoNumber bonusNumber = LottoNumber.provideLottoNumber(10);

        assertThatIllegalArgumentException().isThrownBy(() -> new WinnerLotto(winnerLottoNumbers, bonusNumber))
                .withMessage("보너스볼 번호가 당첨 로또에 이미 있는 번호입니다 :(");
    }
}