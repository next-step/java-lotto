package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    @DisplayName("당첨 번호를 파싱한다")
    void shouldParseWinningNumbers() {
        String input = "1,2,3,4,5,6";

        WinningNumbers winningNumbers = new WinningNumbers(input);

        assertThat(winningNumbers.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("공백이 포함된 당첨 번호를 파싱한다")
    void shouldParseWinningNumbersWithSpaces() {
        String input = "1, 2, 3, 4, 5, 6";

        WinningNumbers winningNumbers = new WinningNumbers(input);

        assertThat(winningNumbers.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다")
    void shouldThrowExceptionWhenNotNumber() {
        String input = "1,2,3,4,5,a";

        assertThatThrownBy(() -> new WinningNumbers(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 숫자여야 합니다.");
    }
}
