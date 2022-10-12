package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    //2 + 3 * 4 / 2
    @Test
    void calculator() {
        assertThat(Calculator.calculate(
                new String[]{"2", "+", "3", "*", "4", "/", "2"}
        )).isEqualTo(10);
    }
}