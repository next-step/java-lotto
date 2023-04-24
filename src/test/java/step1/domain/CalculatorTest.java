package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈을 할 수 있다.")
    void testPlusNumbers() {
        Expression expression = new Expression("2 + 3");

        int result = Calculator.calculate(expression);

        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("덧셈을 할 수 있다.")
    void testMinusNumbers() {
        Expression expression = new Expression("3 - 1");

        int result = Calculator.calculate(expression);

        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈을 할 수 있다.")
    void testMultiplyNumbers() {
        Expression expression = new Expression("3 * 2");

        int result = Calculator.calculate(expression);

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈을 할 수 있다.")
    void testDivideNumbers() {
        Expression expression = new Expression("3 / 2");

        int result = Calculator.calculate(expression);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("순서대로 연산한다.")
    void testOperateInOrder() {
        Expression expression = new Expression("2 + 3 * 4 / 2");

        int result = Calculator.calculate(expression);

        assertThat(result).isEqualTo(10);
    }
}
