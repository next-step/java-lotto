package step1.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringUtilityTest {

    @ParameterizedTest
    @DisplayName("입력값이 null 이거나 빈 문자열일 경우 예외를 발생시킨다.")
    @ValueSource(strings = {"", "    "})
    void validateString(String value) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringUtility.validateString(value));
    }
}
