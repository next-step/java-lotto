package calculator.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    void isNumericTest()
    {
        assertTrue(StringUtil.isNumeric("1234"));
    }

    @Test
    void isNullOrEmptyTest() {
        assertAll(
            () -> StringUtil.isNullOrEmpty(""),
            () -> StringUtil.isNullOrEmpty(null));
    }
}