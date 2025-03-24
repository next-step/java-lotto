import static org.assertj.core.api.Assertions.assertThat;

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
}
