package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @DisplayName("null || empty 문자 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void isEmptyTextTest(String text) {
        int result = StringCalculator.calculate(text);
        assertThat(result).isZero();
    }

    @DisplayName("하나의 문자열 숫자 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void oneTextTest(String text) {
        int result = StringCalculator.calculate(text);
        assertThat(result).isEqualTo(Integer.parseInt(text));
    }

    @DisplayName("음수 예외 처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3"})
    void negativeValidateTest(String text) {
        assertThatThrownBy(() -> StringCalculator.calculate(text))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("(,) 구분자를 포함한 숫자 문자열 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,9=12", "11,14=25"}, delimiter = '=')
    void delimiterCommaIncludeTest(String text, int sum) {
        int result = StringCalculator.calculate(text);
        assertThat(result).isEqualTo(sum);
    }

    @DisplayName("(,|:) 구분자를 포함한 숫자 문자열 테스트")
    @ParameterizedTest
    @CsvSource(value = {"4:20=24", "3,9:10=22"}, delimiter = '=')
    void delimiterCommaOrColonIncludeTest(String text, int sum) {
        int result = StringCalculator.calculate(text);
        assertThat(result).isEqualTo(sum);
    }

    @DisplayName("커스텀 구분자 테스트")
    @Test
    void customPatternTest() {
        int result = StringCalculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }
}
