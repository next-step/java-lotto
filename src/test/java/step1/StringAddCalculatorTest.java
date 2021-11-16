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
        int ans = StringAddCalculator.calculate("1,2:3");
        assertEquals(6, ans);
    }

    @ParameterizedTest
    @NullSource
    void expressionIsNull(String expression) {
        int ans = StringAddCalculator.calculate(expression);
        assertEquals(0, ans);
    }

    @ParameterizedTest
    @EmptySource
    void expressionIsEmpty(String expression) {
        int ans = StringAddCalculator.calculate(expression);
        assertEquals(0, ans);
    }

    @Test
    void calculateComma() {
        int ans = StringAddCalculator.calculate("1,2,3,4");
        assertEquals(10, ans);
    }

    @Test
    void expressionIsOneNumber() {
        int ans = StringAddCalculator.calculate("1");
        assertEquals(1, ans);
    }

    @Test
    void runtimeExceptionBecauseInputNumberLessThan0() {
        assertThatThrownBy(() -> StringAddCalculator.calculate("-1,1"))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    void runtimeExceptionBecauseInputIsNotNumber() {
        assertThatThrownBy(() -> StringAddCalculator.calculate("1,a"))
            .isInstanceOf(RuntimeException.class);
    }
}
