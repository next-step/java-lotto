package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringUtilsTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 공백 반환 시 참 반환 검증")
    void isEmpty_true(String text) {
        assertThat(StringUtils.isEmpty(text)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    @DisplayName("정상적인 문자열인 경우 거짓 반환 검증")
    void isEmpty_false(String text) {
        assertThat(StringUtils.isEmpty(text)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "10", "11"})
    @DisplayName("문자열이 숫자인 경우 참 반환 검증")
    void isNumeric_true(String text) {
        assertThat(StringUtils.isNumeric(text)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1,2,3", "//;\\n1;2;3"})
    @DisplayName("문자열이 숫자가 아닌 경우 거짓 반환 검증")
    void isNumeric_false(String text) {
        assertThat(StringUtils.isNumeric(text)).isFalse();
    }

}
