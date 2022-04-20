package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {
    
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 null 혹은 공백일 경우 IllegalArgumentException 발생")
    void throwIllegalArgumentExceptionWhenInputNullOrEmpty(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 1 + 1:3", "1 + 1 + 1 + 1:4", "1 + 1 + 1 + 1 + 1:5", "1 + 1 + 1 + 1 + 1 + 1:6"}, delimiter = ':')
    @DisplayName("입력값을 더하는 경우")
    void plusTest(String input, Integer expected) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5 - 1 - 1:3", "7 - 1 - 1 - 1:4", "9 - 1 - 1 - 1 - 1:5", "11 - 1 - 1 - 1 - 1 - 1:6"}, delimiter = ':')
    @DisplayName("입력값을 빼는 경우")
    void minusTest(String input, Integer expected) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"4 * 3:12", "5 * 0 * 100:0", "3 * 4 * 5:60"}, delimiter = ':')
    @DisplayName("입력값을 곱하는 경우")
    void multiplyTest(String input, Integer expected) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expected);
    }

}