package step3.util;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    @DisplayName("String 입력 Intger 변경 확인 - 숫자 외 입력시 에러 발생")
    void parseIntCheckText() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.parseInt("a");
        });
        assertThat(exception.getMessage()).isEqualTo("숫자를 입력하세요");
    }
}
