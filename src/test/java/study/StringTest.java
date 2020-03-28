package study;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void matchesTest() {
        String text = "//;\\n1;2;3";
        boolean matchesTrue = text.matches("^//.\\\\n.*$");

        assertThat(matchesTrue).isTrue();
    }

    @Test
    void substringTest() {
        String text = "//;\\n1;2;3";

        String result = text.substring(text.indexOf("//")+2, text.indexOf("\\n"));

        assertThat(result).isEqualTo(";");
    }

}
