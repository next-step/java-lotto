package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private static Calculator calculator;

    @DisplayName("덧셈")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 3", "2 + 3 5", "3 + 4 7"}, delimiter = ' ')
    void plus(int frontNumber, String sign, int backNumber, int expected) {
        calculator = new Calculator(frontNumber, sign, backNumber);
        assertThat(calculator.calculate()).isEqualTo(expected);
    }

    @DisplayName("뺄셈")
    @ParameterizedTest
    @CsvSource(value = {"3 - 1 2", "5 - 4 1", "7 - 4 3"}, delimiter = ' ')
    void minus(int frontNumber, String sign, int backNumber, int expected) {
        calculator = new Calculator(frontNumber, sign, backNumber);
        assertThat(calculator.calculate()).isEqualTo(expected);
    }

    @DisplayName("곱셈")
    @ParameterizedTest
    @CsvSource(value = {"1 * 2 2", "2 * 3 6", "10 * 4 40"}, delimiter = ' ')
    void multiply(int frontNumber, String sign, int backNumber, int expected) {
        calculator = new Calculator(frontNumber, sign, backNumber);
        assertThat(calculator.calculate()).isEqualTo(expected);
    }

    @DisplayName("나눗셈")
    @ParameterizedTest
    @CsvSource(value = {"6 / 2 3", "15 / 3 5", "21 / 3 7"}, delimiter = ' ')
    void divide(int frontNumber, String sign, int backNumber, int expected) {
        calculator = new Calculator(frontNumber, sign, backNumber);
        assertThat(calculator.calculate()).isEqualTo(expected);
    }
}
