package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @Test
    void calculator() {
        assertThat(Calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}