package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 유틸리티")
public class StringUtilsTest {

    @DisplayName("null")
    @Test
    public void isNullOrEmpty() {
        assertThat(StringUtils.isNullOrEmpty(null)).isTrue();
    }

    @DisplayName("빈문자열, 공백문자열")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    public void isNullOrEmpty(String text) {
        assertThat(StringUtils.isNullOrEmpty(text)).isTrue();
    }

}
