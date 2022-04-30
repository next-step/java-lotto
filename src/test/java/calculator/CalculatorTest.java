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
                () -> assertEquals(3, calculator.calculate("1 + 2")),
                () -> assertEquals(5, calculator.calculate("1 + 2 + 2")),
                () -> assertEquals(0, calculator.calculate("2 - 2")),
                () -> assertEquals(2, calculator.calculate("1 * 2")),
                () -> assertEquals(1, calculator.calculate("2 / 2")),
                () -> assertEquals(1, calculator.calculate("1 + 2 / 3"))
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
