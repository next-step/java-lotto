package lotto.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {

    @Test
    void split() throws Exception {
        //given
        String text = "1,2,3";

        //when
        List<String> result = StringSplitter.split(text);

        //then
        assertThat(result).containsExactly("1", "2", "3");
    }
}
