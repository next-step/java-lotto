package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidationUtilTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈문자 또는 NULL 입력 검증 테스트")
    void checkText(String text) {
        assertEquals(true,  ValidationUtil.isBlank(text));
    }
}
