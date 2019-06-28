package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {

    @Test
    void indexOf() {
        String sample = "abcde";
        assertThat(sample.indexOf("b")).isEqualTo(1);

    }
}
