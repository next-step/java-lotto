package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"3 + 4:7", "2 + 3:5", "1 + 2 + 3:6"}, delimiter = ':')
    @DisplayName("입력받은 문자열의 합을 구한다.")
    void plus(String text, int expected) {
        //given
        Calculator calculator = new Calculator();

        //when & then
        assertThat(calculator.calculate(text)).isEqualTo(expected);

    }

    @ParameterizedTest
    @CsvSource(value = {"3 - 4:-1", "3 - 2:1", "1 - 2 + 1:0"}, delimiter = ':')
    @DisplayName("입력받은 문자열의 뺄셈을 구한다.")
    void minus(String text, int expected) {
        //given
        Calculator calculator = new Calculator();

        //when & then
        assertThat(calculator.calculate(text)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3 * 4:12", "3 * 2:6", "1 * 2 * -4:-8"}, delimiter = ':')
    @DisplayName("입력받은 문자열의 곱셈을 구한다.")
    void multiple(String text, int expected) {
        //given
        Calculator calculator = new Calculator();

        //when & then
        assertThat(calculator.calculate(text)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3 / 4:0", "3 / 2:1", "4 / 2 / 2:1"}, delimiter = ':')
    @DisplayName("입력받은 문자열의 나눗셈을 구한다.")
    void divide(String text, int expected) {
        //given
        Calculator calculator = new Calculator();

        //when & then
        assertThat(calculator.calculate(text)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "3 - 2 * 4 + 1:5", "4 / 2 - 2 + 3 * 5:15"}, delimiter = ':')
    @DisplayName("입력받은 문자열의 사칙연산을 구한다.")
    void all(String text, int expected) {
        //given
        Calculator calculator = new Calculator();

        //when & then
        assertThat(calculator.calculate(text)).isEqualTo(expected);
    }
}
