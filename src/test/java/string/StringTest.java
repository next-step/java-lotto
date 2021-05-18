package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void splitTest1() {
        String[] result = "1,2".split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitTest2() {
        String[] result = "1".split(",");

        assertThat(result).contains("1");
    }

    @Test
    void substringTest() {
        String result = "(1,2)".substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAtTest() {
        String input = "abc";

        char result1 = input.charAt(0);
        char result2 = input.charAt(1);
        char result3 = input.charAt(2);

        assertThat(result1).isEqualTo('a');
        assertThat(result2).isEqualTo('b');
        assertThat(result3).isEqualTo('c');
    }

    @Test
    @DisplayName("문자열 길이 밖의 문자 추출 시 StringIndexOutOfBoundsException 예외 발생")
    void StringIndexOutOfBoundsExceptionTest() {
        String input = "abc";
        int length = input.length();

        assertThatThrownBy(() -> input.charAt(length))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: ", length);
    }
}
