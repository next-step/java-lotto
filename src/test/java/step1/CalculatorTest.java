package step1;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import step1.domains.Calculator;

public class CalculatorTest {
    @Test
    void Given_Numbers_When_Plus_Then_Success() {
        assertThat(Calculator.plus(1, 1)).isEqualTo(2);
    }

    @Test
    void Given_Numbers_When_Subtraction_Then_Success() {
        assertThat(Calculator.subtraction(2, 1)).isEqualTo(1);
    }

    @Test
    void Given_Numbers_When_multiply_Then_Success() {
        assertThat(Calculator.multiply(1, 2)).isEqualTo(2);
    }

    @Test
    void Given_Numbers_When_Divide_Then_Success() {
        assertThat(Calculator.divide(4, 2)).isEqualTo(2);
    }
    
    @Test
    void Given_Zero_When_Divide_Then_Fail() {
        assertThatThrownBy(() -> Calculator.divide(1, 0)).isInstanceOf(ArithmeticException.class);
    }
}
