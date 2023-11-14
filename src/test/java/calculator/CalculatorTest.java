package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @DisplayName("입력값이 null 혹은 빈공백 문자열이 아닌지 확인한다.")
    @Test
    void validateInput() {
        Calculator calculator2 = new Calculator(null);
        assertThatThrownBy(calculator2::validateInput)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("null");

        String input = "";
        Calculator calculator = new Calculator(input);
        assertThatThrownBy(calculator::validateInput)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("empty");
    }
}


