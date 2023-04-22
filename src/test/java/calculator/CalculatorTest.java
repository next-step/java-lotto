package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    void 덧셈() {
        Calculator calculator = new Calculator();
        String expression = "2 + 3";
        int result = calculator.add(expression);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        Calculator calculator = new Calculator();
        String expression = "2 - 3";
        int result = calculator.substract(expression);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        Calculator calculator = new Calculator();
        String expression = "2 * 3";
        int result = calculator.multiply(expression);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        Calculator calculator = new Calculator();
        String expression = "10 / 2";
        int result = calculator.divide(expression);

        assertThat(result).isEqualTo(5);
    }
}
