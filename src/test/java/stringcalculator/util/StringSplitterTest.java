package stringcalculator.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {

    @Test
    void split() throws Exception {
        //given
        String text = "2 + 3 * 4 / 2";

        //when
        List<String> result = StringSplitter.split(text);

        //then
        assertThat(result).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }
}