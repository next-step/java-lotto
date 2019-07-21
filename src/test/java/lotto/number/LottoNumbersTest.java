package lotto.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumbersTest {

    @DisplayName("로또 문자열에서 로또 숫자 개수가 6개를 넘어가면 예외를 발생합니다.")
    @Test
    public void testIfCountOfNumberBiggerThan6ThenInvokeException() {
        assertThatIllegalStateException().isThrownBy(() -> LottoNumbers.from("1, 2, 3, 4, 5, 6, 7, 8, 9"));
    }

    @DisplayName("로또 숫자가 중복이 존재한다면 예외를 발생합니다.")
    @Test
    public void testIfLottoNumberNotDistinctThenInvokeException() {
        assertThatIllegalStateException().isThrownBy(() -> LottoNumbers.from("1, 1, 2, 3, 4, 5"));
    }

    @DisplayName("보너스 당첨 숫자가 로또 우승 숫자 리스트에 존재한다면 예외를 발생합니다.")
    @Test
    public void testIfBonusNumberContainInWinnerLottoListThenInvokeException() {
        LottoNumbers winnerLottoNumbers = LottoNumbers.from("1, 2, 3, 4, 5, 6");
        LottoNumbers lottoNumbers = LottoNumbers.from("6, 7, 8, 9, 10, 11");
        LottoNumber bonusLottoNumber = LottoNumber.of("6");
        assertThatIllegalStateException().isThrownBy(() -> lottoNumbers.toLottoRank(winnerLottoNumbers, bonusLottoNumber));
    }
}
