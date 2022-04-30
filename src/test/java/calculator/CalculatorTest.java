package calculator;

import calculator.app.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorTest {
    @Test
    void calculate는_결과를_반환한다() {
        Calculator calculator = new Calculator();

        assertAll(
                () -> assertEquals(calculator.calculate("1 + 2"), 3),
                () -> assertEquals(calculator.calculate("1 + 2 + 2"), 5),
                () -> assertEquals(calculator.calculate("2 - 2"), 0),
                () -> assertEquals(calculator.calculate("1 * 2"), 2),
                () -> assertEquals(calculator.calculate("2 / 2"), 1),
                () -> assertEquals(calculator.calculate("1 + 2 / 3"), 1)
        );
    }

    @Test
    void calculate는_수식이_올바르지_않으면_예외를_발생시킨다() {
        Calculator calc = new Calculator();

        assertThatThrownBy(() -> {
            calc.calculate("10 / 2 1");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
