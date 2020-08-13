package kr.heesu.calculator.utils;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class TextUtilsTest {
    @Test
    void matchTest() {
        String pattern = "";
        assertThat(Pattern.matches(pattern, "-10ds.xadsf")).isFalse();
    }
}
