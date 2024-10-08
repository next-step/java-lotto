package calculator.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void add() {
        int result = Calculator.add(1, 3);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void subtract() {
        int result = Calculator.subtract(5, 3);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void multiply() {
        int result = Calculator.multiply(5, 3);

        assertThat(result).isEqualTo(15);
    }

    @Test
    void divide() {
        int result = Calculator.divide(10, 2);

        assertThat(result).isEqualTo(5);
    }

}
