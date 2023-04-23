package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void add() {
        //given
        String expression = "2 + 3 + 7";
        Calculator calculator = new Calculator(expression);

        // when
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(12);
    }
    @Test
    void subtract() {
        // given
        String expression = "2 - 3";
        Calculator calculator = new Calculator(expression);

        // when
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(-1);
    }
    @Test
    void multiply() {
        // given
        String expression = "2 * 3 * 1 * 10 * -1";
        Calculator calculator = new Calculator(expression);

        // when
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(-60);
    }
    @Test
    void divide() {
        //given
        String expression = "10 / 2";
        Calculator calculator = new Calculator(expression);

        // when
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 / 0", "11 / 2", "3 / 2", "-4 / 3"})
    void when_PrecedingValueIsNotInt_ThrowException(String expression) {

        Calculator calculator = new Calculator(expression);

        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(calculator::calculate);
    }

    @Test
    @DisplayName("여러 사칙연산이 적용된 경우 올바른 값을 반환한다.")
    void when_expressionContainsEveryArithmeticExpression() {
        String expression = "1 + 3 / 2 * 10 - 2 + 1 + -9";
        Calculator calculator = new Calculator(expression);
        int result = calculator.calculate();

        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @DisplayName("값이 하나일때 입력값의 정수 타입을 반환한다.")
    @ValueSource(strings = {"-1","0", "1", "2", "10", "100"})
    void when_ExpressionIsSingleValue(String expression) {
        Calculator calculator = new Calculator(expression);
        int result = calculator.calculate();

        assertThat(result).isEqualTo(Integer.parseInt(expression));
    }
}
