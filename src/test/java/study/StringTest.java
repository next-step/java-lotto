package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("요구사항1: 1,2을 ,로 split 확인")
    @Test
    void split_1_2() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("요구사항1: 1을 ,로 split 확인")
    @Test
    void split_1() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("요구사항2: (1,2)를 substring 확인")
    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("요구사항3: abc를 charAt으로 위치 가져오는 것 확인")
    @Test
    void charAt() {
        String abc = "abc";
        char rt = abc.charAt(0);
        assertThat(rt).isEqualTo('a');
    }

    @DisplayName("요구사항3: StringIndexOutOfBoundsException 확인")
    @Test
    public void testCharAtException() {
        assertThatThrownBy(() -> "abc".charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}