package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null 또는 빈 입력값 예외 테스트")
    void isBlank_exception_test(String input) {
        assertThatThrownBy(() -> StringCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(StringCalculator.INVALID_INPUT_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = "1 ! 1")
    @DisplayName("연산자 예외 테스트")
    void operator_exception_test(String input) {
        assertThatThrownBy(() -> StringCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Operator.INVALID_OPERATOR_MESSAGE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 1 : 2"}, delimiter = ':')
    @DisplayName("덧셈 기능 테스트")
    void plus_test(String input, int output) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource(value = {"3 - 1 : 2"}, delimiter = ':')
    @DisplayName("뺄셈 기능 테스트")
    void minus_test(String input, int output) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 * 2 : 4"}, delimiter = ':')
    @DisplayName("곱셈 기능 테스트")
    void multiply_test(String input, int output) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource(value = {"6 / 3 : 2"}, delimiter = ':')
    @DisplayName("나눗셈 기능 테스트")
    void divide_test(String input, int output) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource(value = {"6 / 3 + 1 - 2 * 2 : 2"}, delimiter = ':')
    @DisplayName("순차적 계산 기능 테스트")
    void calculrate_test(String input, int output) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(output);
    }
}