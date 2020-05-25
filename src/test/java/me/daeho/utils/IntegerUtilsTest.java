package me.daeho.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("문자열 유틸 테스트")
class IntegerUtilsTest {
    @Test
    void isEmpty_null() {
        assertTrue(IntegerUtils.isEmpty(null));
    }

    @Test
    void isEmpty_emptyString() {
        assertTrue(IntegerUtils.isEmpty(""));
        assertTrue(IntegerUtils.isEmpty(" "));
    }


    @Test
    void isOnlyNumber_textAndNumber() {
        assertFalse(IntegerUtils.isOnlyNumber("a123"));
    }

    @Test
    void isOnlyNumber_text() {
        assertFalse(IntegerUtils.isOnlyNumber("foo"));
    }


    @Test
    void isOnlyNumber_number() {
        assertTrue(IntegerUtils.isOnlyNumber("123"));
    }
}




