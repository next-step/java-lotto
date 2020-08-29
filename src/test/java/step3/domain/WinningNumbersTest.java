package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.WinningNumbers;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨번호")
public class WinningNumbersTest {

    @DisplayName("당첨번호 확인")
    @Test
    public void isWinningNumber() {
        WinningNumbers winningNumbers = new WinningNumbers(new int[] { 1, 2, 3 }, 4);
        assertThat(winningNumbers.isWinningNumber(new LottoNo(1))).isTrue();
        assertThat(winningNumbers.isMatchBonus(new LottoNo(1))).isFalse();
        assertThat(winningNumbers.isMatchBonus(new LottoNo(4))).isTrue();
    }

}
