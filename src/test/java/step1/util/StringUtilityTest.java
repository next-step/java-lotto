package step1.util;

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
    void validateString(String value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringUtility.validateString(value));
    }

    @Test
    @DisplayName("입력 값을 공백을 기준으로 자른다.")
    void split() {
        assertThat(StringUtility.split("1 + 2 * 3")).containsExactly("1", "+", "2", "*", "3");
    }
}
