package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

    @ParameterizedTest
    @NullAndEmptySource
    void isNullOrEmpty(String s) {
        boolean isNullOrEmpty = StringUtil.isNullOrEmpty(s);
        assertThat(isNullOrEmpty).isTrue();
    }

    @Test
    void isNullOrEmpty_false() {
        boolean isNullOrEmpty = StringUtil.isNullOrEmpty("a");
        assertThat(isNullOrEmpty).isFalse();
    }

    @Test
    void isSingleWord() {
        boolean isSingleWord = StringUtil.isSingleWord("1");
        assertThat(isSingleWord).isTrue();
    }

    @Test
    void isSingleWord_false() {
        boolean isSingleWord = StringUtil.isSingleWord("11");
        assertThat(isSingleWord).isFalse();
    }
}
