package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    void add() {
        assertThat(Calculator.add(1, 2)).isEqualTo(3);
    }

    @Test
    void subtract() {
        assertThat(Calculator.subtract(1, 0)).isEqualTo(1);
    }

    @Test
    void multiply() {
        assertThat(Calculator.multiply(2, 1)).isEqualTo(2);
    }

    @Test
    void divide() {
        assertThat(Calculator.divide(2, 1)).isEqualTo(2);
    }
}
