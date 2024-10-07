package stringcalculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

    @DisplayName("null, 공백 문자열일 경우 true를 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void isBlankReturnTrue(String input) {
        assertThat(StringUtil.isBlank(input)).isTrue();
    }

    @DisplayName("null, 공백 문자가 아닐 경우 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "1+2"})
    void isBlankReturnFalse(String input) {
        assertThat(StringUtil.isBlank(input)).isFalse();
    }

}