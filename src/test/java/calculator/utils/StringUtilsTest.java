package calculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.StringUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringUtilsTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 공백 반환 시 true 반환 검증")
    void isEmpty_true(String text) {
        assertThat(StringUtils.isEmpty(text)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    @DisplayName("정상적인 문자열인 경우 false 반환 검증")
    void isEmpty_false(String text) {
        assertThat(StringUtils.isEmpty(text)).isFalse();
    }
}
