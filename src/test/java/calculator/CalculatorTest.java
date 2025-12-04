package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void add() {
        Calculator calculator = new Calculator(1, "+", 3);
        int result = calculator.add(2, 3);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void sub() {
        Calculator calculator = new Calculator(1, "-", 3);
        int result = calculator.sub(5, 3);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void mul() {
        Calculator calculator = new Calculator(1, "*", 3);
        int result = calculator.mul(2, 3);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void div() {
        Calculator calculator = new Calculator(1, "/", 3);
        int result = calculator.div(6, 3);
        assertThat(result).isEqualTo(2);
    }
}
