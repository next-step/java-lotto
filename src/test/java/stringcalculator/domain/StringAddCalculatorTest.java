package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {

    @DisplayName("Null 또는 빈문자열은 0을 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyIs0(String expression) {
        int result = StringAddCalculator.calculate(expression);

        assertThat(result).isEqualTo(0);
    }

    @DisplayName("기본 구분자로 구성된 식의 결과를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3|6", "1:5:10|16", "2,5:7|14"}, delimiter = '|')
    void defaultDelimiterSum(String expression, int expectResult) {
        int actualResult = StringAddCalculator.calculate(expression);

        assertThat(actualResult).isEqualTo(expectResult);
    }

    @DisplayName("커스텀 구분자로 구성된 식의 결과를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//&\n1&2&3"})
    void customDelimiterSum(String expression) {
        int actualResult = StringAddCalculator.calculate(expression);

        assertThat(actualResult).isEqualTo(6);
    }

    @DisplayName("식 처음에 빈문자열이 온다면 RuntimeException throw")
    @Test
    void emptyInExpressionThrowException() {
        assertThatThrownBy(() -> StringAddCalculator.calculate(",2:4"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("빈문자열 또는 Null이 입력되었습니다.");
    }

    @DisplayName("식에 숫자가 아닌 값이 있으면 RuntimeException throw")
    @ParameterizedTest
    @ValueSource(strings = {"a,1:c", "//&\n^&3&3"})
    void notNumeralThrowException(String expression) {
        assertThatThrownBy(() -> StringAddCalculator.calculate(expression))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자가 아닙니다.");
    }

    @DisplayName("식에 음수가 있으면 RuntimeException throw")
    @ParameterizedTest
    @ValueSource(strings = {"1,-1:3", "//&\n3&-12&6"})
    void negativeIntegerThrowException(String expression) {
        assertThatThrownBy(() -> StringAddCalculator.calculate(expression))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수가 입력되었습니다.");
    }
}