package step1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import step1.domains.Calculator;
import step1.exceptions.DivideByZeroException;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void Given_Numbers_When_Plus_Then_Success() {
        assertThat(calculator.plus(1, 1)).isEqualTo(2);
    }

    @Test
    void Given_Numbers_When_Subtraction_Then_Success() {
        assertThat(calculator.subtraction(2, 1)).isEqualTo(1);
    }

    @Test
    void Given_Numbers_When_multiply_Then_Success() {
        assertThat(calculator.multiply(1, 2)).isEqualTo(2);
    }

    @Test
    void Given_Numbers_When_Divide_Then_Success() {
        assertThat(calculator.divide(4, 2)).isEqualTo(2);
    }
    
    @Test
    void Given_Zero_When_Divide_Then_Fail() {
        assertThatThrownBy(() -> calculator.divide(1, 0)).isInstanceOf(DivideByZeroException.class);
    }
}
