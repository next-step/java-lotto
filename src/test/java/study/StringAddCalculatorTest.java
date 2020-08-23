package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @DisplayName("null 또는 빈 문자열 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    public void stringNullOrEmpty(String str) {
        int result = StringAddCalculator.splitAndSum(str);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나 문자열 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    public void stringOfOneNumber(String str) {
        int result = StringAddCalculator.splitAndSum(str);
        assertThat(result).isEqualTo(Integer.parseInt(str));
    }

    @DisplayName("음수 문자열 Exception 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1,2,3"})
    public void splitAndSum_negative(String str) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(str))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("쉼표 구분자 문자열 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "5,7=12"}, delimiter = '=')
    public void splitCommaString(String str, int sum) {
        int result = StringAddCalculator.splitAndSum(str);
        assertThat(result).isEqualTo(sum);
    }

    @DisplayName("쉼표 또는 콜론 구분자 문자열 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2,4:8=14", "6,5:3=14"}, delimiter = '=')
    public void splitCommaOrColonString(String str, int sum) {
        int result = StringAddCalculator.splitAndSum(str);
        assertThat(result).isEqualTo(sum);
    }

    @DisplayName("custom 구분자 문자열 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3"})
    public void customPatternString(String str) {
        int result = StringAddCalculator.splitAndSum(str);
        assertThat(result).isEqualTo(6);
    }
}
