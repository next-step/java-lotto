package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @DisplayName("입력값이 null 혹은 빈공백 문자열이 아닌지 확인한다.")
    @Test
    void validateInput() {
        assertThatThrownBy(() -> new Calculator(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("null");

        String input = "";
        assertThatThrownBy(() -> new Calculator(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("empty");
    }

    @DisplayName("입력한 문자를 공백으로 분리한다.")
    @Test
    void splitInput() {
        // given
        String input = "1 + 2 * 3 - 4";

        // when
        Calculator calculator = new Calculator(input);

        // then
        assertThat(calculator.operands())
            .hasSize(4)
            .contains(1);
        assertThat(calculator.operators())
            .hasSize(3)
            .contains("+");
    }

    @DisplayName("사칙연산 기호가 아닌값이 있는지 확인한다.")
    @Test
    void validateOperator() {
        // given
        String input = "1 & 2";

        // when, then
        assertThatThrownBy(() -> new Calculator(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}


