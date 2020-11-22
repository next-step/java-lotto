package utils;

import org.junit.jupiter.api.Test;
import util.StringUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {
    @Test
    public void 양수_입력() {
        assertThat(StringUtils.isPositiveNumber("1000")).isTrue();
    }

    @Test
    public void 음수_입력() {
        assertThat(StringUtils.isPositiveNumber("-1000")).isFalse();
    }

    @Test
    public void 문자_입력() {
        assertThat(StringUtils.isPositiveNumber("test")).isFalse();
    }
}
