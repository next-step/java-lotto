package stringcalculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringUtilityTest {

    @ParameterizedTest
    @DisplayName("입력값이 null 이거나 빈 문자열일 경우 예외를 발생시킨다.")
    @ValueSource(strings = {"", "    "})
    void validateBlankString(String value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringUtility.validateBlankString(value));
    }

    @Test
    @DisplayName("입력 값을 공백을 기준으로 자른다.")
    void split() {
        assertThat(StringUtility.split("1 + 2 * 3")).containsExactly("1", "+", "2", "*", "3");
    }

    @Test
    @DisplayName("입력된 연산자가 올바르지 않을 경우 예외를 발생시킨다.")
    void validateOperator() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringUtility.validateOperator(new String[] {"1", "+", "2", "(", "4"}));
    }

    @Test
    @DisplayName("문자열을 숫자로 형변환한다.")
    void convertToInt() {
        assertThat(StringUtility.convertToInt("3")).isEqualTo(3);
    }
}
