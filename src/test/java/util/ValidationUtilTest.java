package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilTest {

    @Test
    @DisplayName("빈문자 또는 NULL 입력시 0 반환 테스트")
    void checkText() {
        assertEquals(true,  ValidationUtil.isBlank(null));
        assertEquals(true,  ValidationUtil.isBlank(""));
    }
}