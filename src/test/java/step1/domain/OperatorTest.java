package step1.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"0,3", "2,0"})
    void multipleErrorTest(int firstNumber, int secondNumber) {
        assertThatThrownBy(() -> Operator.divide(firstNumber, secondNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,3,0", "4,2,2", "2,2,1", "-2,-1,2", "-4,2,-2", "6,-3,-2", "7,2,3"})
    void divideTest(int firstNumber, int secondNumber, int expectedNumber) {
        assertThat(Operator.divide(firstNumber, secondNumber)).isEqualTo(expectedNumber);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,3,6", "0,2,0", "2,0,0", "-2,-1,2", "-1,2,-2", "2,-3,-6"})
    void multipleTest(int firstNumber, int secondNumber, int expectedNumber) {
        assertThat(Operator.multiple(firstNumber, secondNumber)).isEqualTo(expectedNumber);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,3,-1", "0,2,-2", "2,0,2", "-2,-1,-1", "-1,2,-3", "2,-3,5"})
    void minusTest(int firstNumber, int secondNumber, int expectedNumber) {
        assertThat(Operator.minus(firstNumber, secondNumber)).isEqualTo(expectedNumber);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,3,5", "0,2,2", "2,0,2", "-2,-1,-3", "-1,2,1", "2,-3,-1"})
    void plusTest(int firstNumber, int secondNumber, int expectedNumber) {
        assertThat(Operator.plus(firstNumber, secondNumber)).isEqualTo(expectedNumber);
    }
}
