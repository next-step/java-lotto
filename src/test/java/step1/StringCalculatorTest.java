package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @DisplayName("정수 - 문자열을 숫자로 바꿔 사칙연산을 한다.")
    @ParameterizedTest
    @CsvSource({"2 + 3,5", "5 - 3, 2", "3 - 5,-2", "3 * 5,15", "6 / 2,3"})
    void calculateStringParsedToDouleWhenInputIsInteger(String input, double expectedResult) {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        double result = stringCalculator.calculate(input);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("실수 - 문자열을 숫자로 바꿔 사칙연산을 한다. 단, 나누기는 정수로 표현하고 나머지 연산은 소수점 셋째 자리에서 반올림 한다.")
    @ParameterizedTest
    @CsvSource({"2.5 + 3.2,5.7", "5.78 - 3.23, 2.55", "3.83434 - 5.5456,-1.71", "4.3454 * 7.435345,32.31", "5.345 / 2.342,2"})
    void calculateStringParsedToDouleWhenInputIsRealNumber(String input, double expectedResult) {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        double result = stringCalculator.calculate(input);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}