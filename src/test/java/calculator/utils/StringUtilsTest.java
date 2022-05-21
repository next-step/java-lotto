package calculator.utils;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class StringUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 빈공백_문자열_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringUtils.isNullOrBlank(input));
    }

    @Test
    void null_문자열_테스트() {
        assertThatNullPointerException().isThrownBy(() -> StringUtils.isNullOrBlank(null));
    }
}