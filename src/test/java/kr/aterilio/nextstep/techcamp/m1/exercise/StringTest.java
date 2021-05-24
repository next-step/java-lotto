package kr.aterilio.nextstep.techcamp.m1.exercise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    public static final String SPLIT_TOKEN = ",";

    @DisplayName("split \"1,2\" -> expected {\"1\", \"2\"}")
    @Test
    public void testReq1_splitTwoElement() {
        final String input = "1,2";
        final String[] result = input.split(SPLIT_TOKEN);
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("split \"1\" -> expected {\"1\"}")
    @Test
    public void testReq1_splitOneElement() {
        final String input = "1";
        final String[] result = input.split(SPLIT_TOKEN);
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("substring \"(1,2)\" -> expected \"1,2\"")
    @Test
    public void testReq2_substring() {
        final String input = "(1,2)";
        final String result = input.substring(1, 4);
        assertThat(result).isEqualTo("1,2");

    }

    @DisplayName("charAt \"abc\" -> expected 0:'a', 1:'b', 2:'c'")
    @Test
    public void testReq3_charAt() {
        final String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @DisplayName("charAt \"abc\" -> expected 4:throw IndexOutOfBoundsException")
    @Test
    public void testReq3_charAtThrowOutOfBoundException() {
        final String input = "abc";
        assertThatThrownBy(() -> {
            input.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining("out of range: 4");
    }
}
