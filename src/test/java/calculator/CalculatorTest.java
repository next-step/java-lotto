package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void plus_덧셈() {
        int result = Calculator.PLUS.calculate(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void minus_뺼셈() {
        int result = Calculator.MINUS.calculate(2, 1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void multiply_곱셈() {
        int result = Calculator.MULTIPLY.calculate(2, 4);
        assertThat(result).isEqualTo(8);
    }

    @Test
    void divide_나눗셈() {
        int result = Calculator.DIVIDE.calculate(10, 2);
        assertThat(result).isEqualTo(5);
    }
}
