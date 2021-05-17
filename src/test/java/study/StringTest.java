package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("split 테스트")
    @Test
    void split() {
        //when
        String[] result = "1,2".split(",");

        //then
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("substring 테스트")
    @Test
    void substring() {
        //given
        String str = "(1,2)";

        //when
        str = str.substring(1, str.length() - 1);

        //then
        assertThat(str).isEqualTo("1,2");
    }

    @DisplayName("charAt 테스트")
    @Test
    void charAt() {
        //when
        char c = "abc".charAt(1);

        //then
        assertThat(c).isEqualTo('b');
    }

    @DisplayName("charAt이 위치값을 벗어나는 경우")
    @Test
    void charAtInvokeException() {
        //when, then
        assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
