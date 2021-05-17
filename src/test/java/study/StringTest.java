package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split_1_2() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_1() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }
}