package calculator.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {


    @Test
    void 빈값_예외() {
        assertThatThrownBy(() -> StringCalculator.calculate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void null_예외() {
        assertThatThrownBy(() -> StringCalculator.calculate(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
