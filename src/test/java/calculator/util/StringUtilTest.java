package calculator.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    @DisplayName("문자열이 비어있지 않은 경우 성공 테스트")
    void isEmpty_메서드_성공_테스트() {
        assertThat(StringUtil.isEmpty("2")).isEqualTo("2");
    }

    @Test
    @DisplayName("빈 공백 입력 시 예외 발생 테스트")
    void 빈_공백_입력_에러_테스트(){
        assertThatThrownBy(() -> StringUtil.isEmpty(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("null 또는 빈 공백을 입력할 수 없습니다.");

    }

    @Test
    @DisplayName("null 입력 시 예외 발생 테스트")
    void null_입력_에러테스트() {
        assertThatThrownBy(() -> StringUtil.isEmpty(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("null 또는 빈 공백을 입력할 수 없습니다.");
    }
}