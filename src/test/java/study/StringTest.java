package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {

    @Test
    void split() {
        final String input = "1,2";
        final String[] result = input.split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        final String input = "(1,2)";
        final String substring = input.substring(1, input.length() - 1);

        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("문자열의 인덱스에 해당하는 문자를 리턴한다")
    @Test
    void charAtWithValidIndex() {
        final String input = "abc";

        assertThat(input.charAt(0)).isEqualTo('a');
    }

    @DisplayName("문자열의 인덱스를 통한 문자 리턴시, 인덱스가 유효하지 않으면 예외를 던진다")
    @Test
    void charAtWithInValidIndex() {
        final String input = "abc";

        assertThatThrownBy(() -> {
            input.charAt(99);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
