package stringCalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2:+:3", "10:2:+:12", "7:5:+:12"}, delimiter = ':')
    @DisplayName("더하기 연산을 한다.")
    void plus(String firstNumber, String secondNumber, String operator, int expectedResult) {
        StringCalculator stringCalculator = new StringCalculator(firstNumber, secondNumber, operator);

        int actual = stringCalculator.calculate();

        assertThat(actual).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:-:-1", "10:2:-:8", "7:5:-:2"}, delimiter = ':')
    @DisplayName("빼기 연산을 한다.")
    void minus(String firstNumber, String secondNumber, String operator, int expectedResult) {
        StringCalculator stringCalculator = new StringCalculator(firstNumber, secondNumber, operator);

        int actual = stringCalculator.calculate();

        assertThat(actual).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:*:2", "10:2:*:20", "7:5:*:35"}, delimiter = ':')
    @DisplayName("곱셈 연산을 한다.")
    void multiply(String firstNumber, String secondNumber, String operator, int expectedResult) {
        StringCalculator stringCalculator = new StringCalculator(firstNumber, secondNumber, operator);

        int actual = stringCalculator.calculate();

        assertThat(actual).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:1:/:2", "10:2:/:5", "10:5:/:2"}, delimiter = ':')
    @DisplayName("나눗셈 연산을 한다.")
    void divide(String firstNumber, String secondNumber, String operator, int expectedResult) {
        StringCalculator stringCalculator = new StringCalculator(firstNumber, secondNumber, operator);

        int actual = stringCalculator.calculate();

        assertThat(actual).isEqualTo(expectedResult);
    }
}
