package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringAddCalculatorTest {

    @DisplayName("빈 문자열 또는 null 입력 시 0을 반환")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @NullAndEmptySource
    void calculate_ReturnZero_IfInputIsNullOrEmpty(String input) {
        int result = StringAddCalculator.calculate(new Formulas(input));
        assertThat(result).isZero();
    }

    @DisplayName("숫자 하나 입력 시 해당 숫자를 반환")
    @Test
    void calculate_ReturnInputNumber_IfInputIsOneNumber() {
        String input = "10";
        Formulas formulas = new Formulas(input);
        int result = StringAddCalculator.calculate(formulas);
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("쉼표 또는 콜론 구분자로 분리한 각 숫자의 합을 반환")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @CsvSource(value = {"'1,2'/3", "'2:3'/5", "3,5:8/16"}, delimiter = '/')
    void calculate_ReturnSum_IfInputHasCommaOrColonDelimiter(String input, int expected) {
        Formulas formulas = new Formulas(input);
        int result = StringAddCalculator.calculate(formulas);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자로 분리한 각 숫자의 합을 반환")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @CsvSource(value = {"'@', '1@2@6', 9", "'#', '2#3', 5", "'a', '8a13a7', 28"})
    void calculate_ReturnSum_IfInputHasCustomDelimiter(String customDelimiter, String inputFormulas, int expected) {
        String input = "//" + customDelimiter + "\n" + inputFormulas;
        Formulas formulas = new Formulas(input);
        int result = StringAddCalculator.calculate(formulas);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("숫자가 아닌 값을 포함할 경우 RuntimeException 발생")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @CsvSource(value = {"1:6:#", "a", "//@\n3@abc@73"})
    void calculate_ThrowsRuntimeException_IfInputHasNonNumericValue(String input) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(
                () -> StringAddCalculator.calculate(new Formulas(input)));
    }
}
