import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @DisplayName("null 또는 Empty 받으면 0을 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyFormulaReturnZero(String formula) {
        int result = StringAddCalculator.splitAndSum(formula);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 입력하면 해당 숫자 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void onlyOneNumberInput(String number) {
        int result = StringAddCalculator.splitAndSum(number);
        assertThat(result).isEqualTo(Integer.parseInt(number));
    }

    @DisplayName("구분자로 컴마 사용 가능")
    @ParameterizedTest
    @CsvSource(value = {"1,2?3"}, delimiter = '?')
    void splitComma(String formula, int expected) {
        int result = StringAddCalculator.splitAndSum(formula);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("구분자로 컴마와 콜론 사용 가능")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3?6"}, delimiter = '?')
    void splitCommaAndColon(String formula, int expected) {
        int result = StringAddCalculator.splitAndSum(formula);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자 사용 가능")
    @Test
    void splitCustomDelimiter() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수 입력시 RuntimeException")
    @ParameterizedTest
    @CsvSource(value = {"2,-1:3"}, delimiter = ';')
    void defaultDelimiterNegative(String formula) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(formula))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("커스텀 delimiter 음수 입력시 RuntimeException")
    @Test
    void customDelimiterNegative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//;\n1;2;-1"))
                .isInstanceOf(RuntimeException.class);
    }
}
