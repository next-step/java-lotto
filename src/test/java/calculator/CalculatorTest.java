package calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {
    @Test
    void calculator() {
        assertThat(Calculator.from("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    void calculate_nonArithmetic_operation_expression() {
        assertThatThrownBy(() -> Calculator.from("2 & 5 / 1 ! 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculate_not_a_number() {
        assertThatThrownBy(() -> Calculator.from("a + b / c - d"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
