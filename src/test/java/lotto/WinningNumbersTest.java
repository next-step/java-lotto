package lotto;

import lotto.model.WinningPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringformula.exception.DuplicateBonusNumberException;

import static lotto.utils.TestUtils.testLottoNumbers;
import static lotto.utils.TestUtils.testWinningNumbers;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {

    @Test
    @DisplayName("WinningNumbers 객체 생성 시 보너스 번호가 중복으로 생성하려 할 때 예외가 발생한다")
    void 테스트_객체_생성_예외_발생() {
        // given

        // when

        // then
        assertThrows(DuplicateBonusNumberException.class, () -> new WinningNumbers(testLottoNumbers(),
                new LottoNumber(6)));
    }

    @Test
    @DisplayName("winningCount 메소드는 당첨된 로또 번호 개수를 반환한다")
    void 테스트_winningCount_당첨된_로또_개수_반환한다() {
        // given
        WinningNumbers winningNumbers = testWinningNumbers();

        // when
        int result = winningNumbers.winningCount(testLottoNumbers(1,2,3,4,5,6));

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("isBonusMatch 보너스 번호의 당첨 여부를 반환한다 ")
    void 테스트_isBonusMatch_보너스_번호의_매치_여부를_반환() {
        // given
        WinningNumbers winningNumbers = testWinningNumbers();

        // when

        // then
        assertFalse(winningNumbers.isBonusMatch(testLottoNumbers(1,2,3,4,5,6)));
        assertTrue(winningNumbers.isBonusMatch(testLottoNumbers(1,2,3,4,5,7)));
    }
}