package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    @DisplayName("덧셈")
    void plus() {
        int a = 10;
        int b = 20;

        Calculator calculator = new Calculator();
        int result = calculator.plus(a,b);

        assertThat(result).isEqualTo(30);
    }

}