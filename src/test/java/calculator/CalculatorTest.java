package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setup() {
        this.calculator = new Calculator();
    }

    @Test
    void calculator() {
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}