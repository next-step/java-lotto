package camp.nextstep.edu.rebellion.calc.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {
    @DisplayName("null 일 경우 empty 확인")
    @Test
    public void nullTest() {
        // when & then
        assertThat(StringUtil.isEmpty(null)).isTrue();
    }

    @DisplayName("빈 공백 일 경우 empty 확인")
    @ParameterizedTest
    @ValueSource(strings = {"", "     "})
    public void emptySpaceTest(String input) {
        // when & then
        assertThat(StringUtil.isEmpty(input)).isTrue();
    }
}
