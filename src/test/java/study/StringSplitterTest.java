package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {

    @Test
    void split_쉼표구분자() {
        String[] strings = StringSplitter.split("a,b,c");
        assertThat(strings).isEqualTo(new String[]{"a", "b", "c"});
    }

    @Test
    void split_쉼표또는콜론구분자() {
        String[] strings = StringSplitter.split("a,b:c");
        assertThat(strings).isEqualTo(new String[]{"a", "b", "c"});
    }

    @Test
    void split_custom구분자() {
        String[] strings = StringSplitter.split("//;\na;b;c");
        assertThat(strings).isEqualTo(new String[]{"a", "b", "c"});
    }
}
