package step1.util;

import org.junit.jupiter.api.Test;
import step1.domain.StringAddCalculator;
import step1.domain.StringSplit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringUtilTest {

    @Test
    public void isEmptyTest() {
        assertThat(StringUtil.isEmpty("")).isTrue();
        assertThat(StringUtil.isEmpty("dd")).isFalse();
    }
}
