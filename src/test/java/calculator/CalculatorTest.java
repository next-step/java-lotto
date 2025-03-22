package calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @Test
    @DisplayName("덧셈")
    public void plus() {
        int actual = Calculator.calculate(1, "+", 2);

        int expected = 3;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("뺄셈")
    public void minus() {
        int actual = Calculator.calculate(5, "-", 2);

        int expected = 3;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("곱셈")
    public void multiply() {
        int actual = Calculator.calculate(3, "*", 3);

        int expected = 9;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("나눗셈")
    public void divide() {
        int actual = Calculator.calculate(4, "/", 2);

        int expected = 2;
        assertThat(actual).isEqualTo(expected);
    }

}