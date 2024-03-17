package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

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
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate(input));
    }

    @ParameterizedTest
    @DisplayName("")
    @ValueSource(strings = {"1m2m32", "1 + 2 3 4 5", "1 / 2 /", "1 + 2 d 3"})
    void testInvalidExpression(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate(input));
    }
}
