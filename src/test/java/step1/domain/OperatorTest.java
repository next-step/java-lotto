package step1.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2,3,0", "4,2,2", "2,2,1", "-2,-1,2", "-4,2,-2", "6,-3,-2", "7,2,3"})
    void divideTest(int firstNumber, int secondNumber, int expectedNumber) {
        assertThat(Operator.DIVIDE.calculate(firstNumber, secondNumber)).isEqualTo(expectedNumber);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,3,6", "0,2,0", "2,0,0", "-2,-1,2", "-1,2,-2", "2,-3,-6"})
    void multipleTest(int firstNumber, int secondNumber, int expectedNumber) {
        assertThat(Operator.MULTIPLE.calculate(firstNumber, secondNumber)).isEqualTo(expectedNumber);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,3,-1", "0,2,-2", "2,0,2", "-2,-1,-1", "-1,2,-3", "2,-3,5"})
    void minusTest(int firstNumber, int secondNumber, int expectedNumber) {
        assertThat(Operator.MINUS.calculate(firstNumber, secondNumber)).isEqualTo(expectedNumber);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,3,5", "0,2,2", "2,0,2", "-2,-1,-3", "-1,2,1", "2,-3,-1"})
    void plusTest(int firstNumber, int secondNumber, int expectedNumber) {
        assertThat(Operator.PLUS.calculate(firstNumber, secondNumber)).isEqualTo(expectedNumber);
    }
}
