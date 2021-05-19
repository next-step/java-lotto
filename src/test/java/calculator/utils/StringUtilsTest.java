package calculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @DisplayName("null 또는 공백을 전달하면 true 반환한다")
    @ParameterizedTest
    @NullAndEmptySource
    void isBlank(String value) {
        assertThat(StringUtils.isBlank(value)).isTrue();
    }

    @DisplayName("숫자인 문자를 입력하면 true 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"-1,true", "0,true", "1,true", "권,false", "k,false"})
    void isNumber(String value, boolean expected) {
        assertThat(StringUtils.isNumber(value)).isEqualTo(expected);
    }
}
