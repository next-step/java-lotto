package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split() {
        //when
        String[] result = "1,2".split(",");
        //then
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }
}
