package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private static final Calculator calculator = new Calculator();

    @Test
    void 덧셈() {
        String input = "2 + 3";
        assertThat(calculator.calculate(input)).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        String input = "5 - 3";
        assertThat(calculator.calculate(input)).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        String input = "5 * 3";
        assertThat(calculator.calculate(input)).isEqualTo(15);
    }

    @Test
    void 나눗셈() {
        String input = "15 / 3";
        assertThat(calculator.calculate(input)).isEqualTo(5);
    }

    @Test
    void 사칙연산_혼합() {
        String input = "2 + 3 * 4 / 2";
        assertThat(calculator.calculate(input)).isEqualTo(10);
    }
}
