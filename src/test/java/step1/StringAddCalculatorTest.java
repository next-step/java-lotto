package step1;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class StringAddCalculatorTest {

    @Test
    void stringAddCalculator() {
        Number ans = StringAddCalculator.calculate(new Expression("1,2:3"));
        assertEquals(new Number(6), ans);
    }

    @ParameterizedTest
    @NullSource
    void expressionIsNull(String expression) {
        Number ans = StringAddCalculator.calculate(new Expression(expression));
        assertEquals(new Number(0), ans);
    }

    @ParameterizedTest
    @EmptySource
    void expressionIsEmpty(String expression) {
        Number ans = StringAddCalculator.calculate(new Expression(expression));
        assertEquals(new Number(0), ans);
    }

    @Test
    void calculate() {
        Number ans = StringAddCalculator.calculate(new Expression("1,2:3,4"));
        assertEquals(new Number(10), ans);
    }

    @Test
    void expressionIsOneNumber() {
        Number ans = StringAddCalculator.calculate(new Expression("1"));
        assertEquals(new Number(1), ans);
    }

    @Test
    void runtimeExceptionBecauseInputNumberLessThan0() {
        assertThatThrownBy(() -> StringAddCalculator.calculate(new Expression("-1,1")))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    void runtimeExceptionBecauseInputIsNotNumber() {
        assertThatThrownBy(() -> StringAddCalculator.calculate(new Expression("1,a")))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    void calculateCustomDelimiter() {
        Number ans = StringAddCalculator.calculate(new Expression("//;\n1;2;3"));
        assertEquals(new Number(6), ans);
    }
}
