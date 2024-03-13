package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void add() {
        int result = calculator.add(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void subtract() {
        int result = calculator.subtract(5, 4);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void multiply() {
        int result = calculator.multiply(2, 4);
        assertThat(result).isEqualTo(8);
    }

    @Test
    void divide() {
        int result = calculator.divide(8, 4);
        assertThat(result).isEqualTo(2);
    }
}
