package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void splitStringTest() {
        String stringData = "1,2";
        String[] stringArray = stringData.split(",");
        assertThat(stringArray).containsExactly("1", "2");
    }

    @Test
    void splitStringContainTest() {
        String stringData = "1,";
        String[] stringArray = stringData.split(",");
        assertThat(stringArray).containsOnly("1");
    }

    @Test
    void subStringTest() {
        String stringData = "(1,2)";
        assertThat(stringData.substring(1, stringData.length() - 1)).isEqualTo("1,2");
    }
}
