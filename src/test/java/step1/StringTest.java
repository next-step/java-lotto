package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("1,2를 ,로 split 했을경우 1과 2가 리턴")
    public void splitTest() {
        String input = "1,2";
        assertThat(input.split(","))
                .hasSize(2)
                .contains("1","2")
                .containsExactly("1","2");
    }
    @Test
    @DisplayName("1만 ,로 스플릿 했을경우 1이 리턴")
    public void splitTest2() {
        String data = "1";
        String delimeter = ",";
        assertThat(data.split(delimeter)).hasSize(1)
                .containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)가 주어졌을때 substring을 이용해서 ()를 제거하고 1,2만 리턴")
    public void substringTest() {
        String data = "(1,2)";
        assertThat(data.substring(1,data.length()-1))
                .isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt을 이용해서 특정위치의 char형 문자를 리턴")
    public void charAtTest() {
        String data= "abc";
        assertThat(data.charAt(0)).isEqualTo('a');
        assertThat(data.charAt(1)).isEqualTo('b');
        assertThat(data.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt을 이용해서 길이를 벗어나면 StringIndexOutOfBoundsException 리턴")
    public void charAtExceptionTest() {
        String data = "abc";
        assertThatThrownBy(()->data.charAt(data.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 3");

    }
}
