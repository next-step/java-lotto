package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("String split 테스트")
    void splitStringTest() {
        String stringData = "1,2";
        String[] stringArray = stringData.split(",");
        assertThat(stringArray).containsExactly("1", "2");

    }

    @Test
    @DisplayName("String split 특정 값 체크 테스트")
    void splitStringContainTest() {
        String stringData = "1,";
        String[] stringArray = stringData.split(",");
        assertThat(stringArray).containsOnly("1");
    }

    @Test
    @DisplayName("subString 테스트")
    void subStringTest() {
        String stringData = "(1,2)";
        assertThat(stringData.substring(1, stringData.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 테스트")
    void charAtTest() {
        String stringData = "abc";
        assertThat(stringData.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt StringIndexOutOfBoundsException 테스트")
    void charAtExceptionTest() {
        String stringData = "abc";
        assertThatThrownBy(() -> stringData.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: %d", stringData.length());
    }
}
