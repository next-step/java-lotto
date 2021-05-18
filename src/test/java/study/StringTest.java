package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("콤마로 스트링 분리")
    @Test
    void commaDelimeterTest(){
        String source = "1,2";
        String[] actual = source.split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @DisplayName("괄호 제외한 문자열 반환")
    @Test
    void excludeBraceTest(){
        String source = "(1,2)";
        String expected = "1,2";
        String actual = source.substring(source.indexOf("(") + 1, source.indexOf(")"));
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("특정 위치의 문자 가져오기")
    @Test
    void getCharAtIndexTest(){
        String source = "abc";
        char expected = 'b';
        char actual = source.charAt(1);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("문자열 인덱스 초과 조회는 예외 발생")
    @Test
    void exceptionWhileAccessOutOfIndex(){
        assertThatThrownBy(() -> {
            String source = "abc";
            char expected = 'b';
            char actual = source.charAt(1000);
        }).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining("out");
    }
}
