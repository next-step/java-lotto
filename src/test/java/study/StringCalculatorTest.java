package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @DisplayName("사칙연산 결과 테스트")
    @CsvSource(value = {"2 + 3 * 4 / 2,10", "2 + 3 * 4 - 4,16"}, delimiter = ',')
    void testFourOperation(String input, int expected) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("null이나 빈 문자열 올 경우 예외 발생")
    @NullAndEmptySource
    void testNullOrEmptyString(String input) {
        assertThatThrownBy(() -> stringCalculator.calculate(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
