package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {
    @Test
    @DisplayName("문자열 split 테스트")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 substring 테스트")
    void subString() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).contains("1,2");
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 chatAt Index 예외 테스트")
    void chatAt() {
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(3))
                .withMessageMatching("String index out of range: 3");
    }
}
