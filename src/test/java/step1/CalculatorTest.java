package step1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void Given_Numbers_When_Plus_Success() {
        assertThat(calculator.plus(1, 1)).isEqualTo(2);
    }

    @Test
    void Given_Numbers_When_Subtraction_Success() {
        assertThat(calculator.subtraction(2, 1)).isEqualTo(1);
    }

    @Test
    void Given_Numbers_When_multiply_Success() {
        assertThat(calculator.multiply(1, 2)).isEqualTo(2);
    }

    @Test
    void Given_Numbers_When_Divide_Success() {
        assertThat(calculator.divide(4, 2)).isEqualTo(2);
    }
}
