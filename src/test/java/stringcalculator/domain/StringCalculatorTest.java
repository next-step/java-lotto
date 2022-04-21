package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @CsvSource(value = {"4 / 2:2", "4 / 2 / 2:1", "100 / 2 / 5:10"}, delimiter = ':')
    @DisplayName("입력값을 나누는 경우")
    void divideTest(String input, Integer expected) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("0으로 나눌 경우 IllegalArgumentException 발생")
    void divideByZero() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate("4 / 0"))
                .withMessage("Cannot divide by zero");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a + b", "! - !", "/ / /"})
    @DisplayName("입력값이 숫자가 아닐 경우 IllegalArgumentException 발생")
    void throwIllegalArgumentExceptionWhenInputNotNumber(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate(input))
                .withMessage("Invalid input");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ! 1", "1 - 2 $ 1", "5 ( 1 * 4"})
    @DisplayName("연산자가 잘못 입력된 경우 IllegalArgumentException 발생")
    void throwIllegalArgumentExceptionWhenInputInvalidOperator(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate(input))
                .withMessage("Invalid operator");
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 1 * 4:8", "1 - 2 / 1 + 100:99", "1 + 5 + 3 - 1:8", "4 + 4 + 4:12"}, delimiter = ':')
    @DisplayName("계산기 테스트")
    void calculatorTest(String input, int expected) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expected);
    }
}