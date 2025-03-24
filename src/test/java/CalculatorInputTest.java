import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorInputTest {

    @Test
    @DisplayName("문자열 입력 받기")
    void canCreateCalculatorInput() {
        String input = "2 + 3 * 4 / 2";
        CalculatorInput calculatorInput = new CalculatorInput(input);
        assertThat(calculatorInput.getInput()).isEqualTo(input);
    }

    @Test
    @DisplayName("공백으로 문자, 숫자 분리")
    void canTokenize() {
        String input = "2 + 3 * 4 / 2";
        CalculatorInput calculatorInput = new CalculatorInput(input);
        assertThat(calculatorInput.getTokens()).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @Test
    @DisplayName("입력값이 null이거나 빈 문자열일 경우 예외 발생")
    void throwsExceptionWhenInputIsNull() {
        assertThatThrownBy(() -> new CalculatorInput(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력값은 null이거나 빈 문자열일 수 없습니다.");

        assertThatThrownBy(() -> new CalculatorInput(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력값은 null이거나 빈 문자열일 수 없습니다.");

        assertThatThrownBy(() -> new CalculatorInput("   "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력값은 null이거나 빈 문자열일 수 없습니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 값이 입력되면 예외가 발생한다.")
    void shouldThrowExceptionWhenInputIsNotNumber() {
        assertThatThrownBy(() -> new CalculatorInput("a + 3"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자가 아닌 값이 입력되었습니다: a");
    }

    @Test
    @DisplayName("지원하지 않는 연산자가 입력되면 예외가 발생한다.")
    void shouldThrowExceptionWhenOperatorIsNotSupported() {
        assertThatThrownBy(() -> new CalculatorInput("2 % 3"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("지원하지 않는 연산자입니다: %");
    }
}
