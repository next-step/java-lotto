package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @Test
    @DisplayName("덧셈")
    public void plus() {
        OperationUnit unit = new OperationUnit(1, "+", 2);
        int actual = Calculator.calculate(unit);

        int expected = 3;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("뺄셈")
    public void minus() {
        OperationUnit unit = new OperationUnit(5, "-", 2);
        int actual = Calculator.calculate(unit);

        int expected = 3;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("곱셈")
    public void multiply() {
        OperationUnit unit = new OperationUnit(3, "*", 3);
        int actual = Calculator.calculate(unit);

        int expected = 9;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("나눗셈")
    public void divide() {
        OperationUnit unit = new OperationUnit(4, "/", 2);
        int actual = Calculator.calculate(unit);

        int expected = 2;
        assertThat(actual).isEqualTo(expected);
    }

}