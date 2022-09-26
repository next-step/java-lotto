package calculator.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class OperandTest {

    @ParameterizedTest
    @CsvSource(value = {"1,-1,0", "-3,4,1"})
    void shouldPlus(String x, String y, String expectedResult) {
        assertThat(new Operand(x).plus(new Operand(y))).isEqualTo(new Operand(expectedResult));
    }

    @ParameterizedTest
    @CsvSource(value = {"-1,-1,0", "-3,4,-7"})
    void shouldMinus(String x, String y, String expectedResult) {
        assertThat(new Operand(x).minus(new Operand(y))).isEqualTo(new Operand(expectedResult));
    }

    @ParameterizedTest
    @CsvSource(value = {"-1,-1,1", "-3,4,-12"})
    void shouldMultiply(String x, String y, String expectedResult) {
        assertThat(new Operand(x).multiply(new Operand(y))).isEqualTo(new Operand(expectedResult));
    }

    @ParameterizedTest
    @CsvSource(value = {"-1,-1,1", "-3,4,0", "10,5,2"})
    void shouldDivide(String x, String y, String expectedResult) {
        assertThat(new Operand(x).divide(new Operand(y))).isEqualTo(new Operand(expectedResult));
    }

    @Test
    void shouldThrowExceptionWhenDivisorIsZero() {
        assertThrowsExactly(ArithmeticException.class, () -> new Operand("10").divide(new Operand("0")));
    }
}
