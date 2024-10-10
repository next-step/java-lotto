package calculator.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  "})
    void isEmpty는_빈문자열_또는_null에_대해_true를_반환한다(String input) {
        assertThat(StringUtil.isEmpty(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1", "가"})
    void isEmpty는_빈문자열_또는_null이_아니면_false를_반환한다(String input) {
        assertThat(StringUtil.isEmpty(input)).isFalse();
    }
}