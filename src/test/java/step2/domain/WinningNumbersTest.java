package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨번호")
public class WinningNumbersTest {

    @DisplayName("당첨번호 확인")
    @Test
    public void isWinningNumber() {
        WinningNumbers winningNumbers = new WinningNumbers(new int[] { 1, 2, 3 });
        assertThat(winningNumbers.isWinningNumber(1)).isTrue();
    }

}
