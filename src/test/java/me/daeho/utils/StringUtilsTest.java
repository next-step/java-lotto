package me.daeho.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("문자열 유틸 테스트")
class StringUtilsTest {
    @Test
    void isEmpty_null() {
        assertTrue(StringUtils.isEmpty(null));
    }

    @Test
    void isEmpty_emptyString() {
        assertTrue(StringUtils.isEmpty(""));
        assertTrue(StringUtils.isEmpty(" "));
    }
}