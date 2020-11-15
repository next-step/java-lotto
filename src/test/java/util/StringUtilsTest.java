package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {
    @DisplayName("공백 문자열이 들어온 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "         "})
    void isBlank_when_receive_blank_str(final String blank) {
        // when
        final boolean result = StringUtils.isBlank(blank);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("null 문자열이 들어온 경우")
    @Test
    void isBlank_when_receive_blank_str() {
        // given
        final String nullStr = null;

        // when
        final boolean result = StringUtils.isBlank(nullStr);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("비지 않은 문자열이 들어온 경우")
    @Test
    void isBlank_when_receive_not_blank_str() {
        // given
        final String Str = "str ";

        // when
        final boolean result = StringUtils.isBlank(Str);

        // then
        assertThat(result).isFalse();
    }
}