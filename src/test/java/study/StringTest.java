package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String given = "(1,2)";
        String result = given.substring(1, given.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String given = "abc";
        assertThatThrownBy(() -> given.charAt(given.length())
        ).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + given.length());
    }

}
