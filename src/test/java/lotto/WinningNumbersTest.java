package lotto;

import lotto.model.WinningPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.utils.TestUtils.testLottoNumbers;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {
    @Test
    @DisplayName("winningCount 메소드는 당첨된 로또 번호 개수를 반환한다")
    void 테스트_winningCount_당첨된_로또_개수_반환한다() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(testLottoNumbers(), new LottoNumber(7));

        // when
        int result = winningNumbers.winningCount(testLottoNumbers(1,2,3,4,5,6));

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("isBonusMatch 보너스 번호의 당첨 여부를 반환한다 ")
    void 테스트_isBonusMatch_보너스_번호의_매치_여부를_반환() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(testLottoNumbers(), new LottoNumber(7));

        // when

        // then
        assertFalse(winningNumbers.isBonusMatch(testLottoNumbers(1,2,3,4,5,6)));
        assertTrue(winningNumbers.isBonusMatch(testLottoNumbers(1,2,3,4,5,7)));
    }
}