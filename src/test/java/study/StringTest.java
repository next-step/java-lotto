package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {
    //요구사항 1
    @Test
    @DisplayName("특정문자로 문자열을 잘라 String배열을 반환하는 split 테스트")
    void split() {
        assertThat("1,2".split(",")).contains("1");
        assertThat("1,2".split(",")).contains("1","2");
        assertThat("1".split(",")).contains("1");
        assertThat("1,2".split(",")).containsExactly("1","2");
        assertThat("1,2".split(",")).contains("2","1");
    }
    //요구사항 2
    @Test
    @DisplayName("지정범위의 문자열을 반환하는 substring 테스트")
    void substring() {
        String data = "(1,2)";
        assertThat(data.substring(1,4)).isEqualTo("1,2");
    }
    //요구사항 3-1
    @Test
    @DisplayName("특정위치의 문자를 가져오는 charAt 테스트")
    void charAt() {
        String data = "abc";
        assertThat(data.charAt(0)).isEqualTo('a');
    }
    //요구사항 3-2
    @Test
    @DisplayName("charAt 파라미터가 범위를 벗어날경우 StringIndexOutOfBoundException 발생 테스트")
    void charAtWithException() {
        String data = "abc";
        assertThrows(StringIndexOutOfBoundsException.class,() -> data.charAt(3));
        assertThatThrownBy(() -> data.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> data.charAt(3))
                .withMessageMatching("String index out of range: \\d+");
    }
}
