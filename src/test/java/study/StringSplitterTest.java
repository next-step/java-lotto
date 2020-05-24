package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {

    private StringSplitter splitter = new StringSplitter();

    @Test
    void split_쉼표구분자() {
        String[] strings = splitter.split("a,b,c");
        assertThat(strings).isEqualTo(new String[]{"a", "b", "c"});
    }

    @Test
    void split_쉼표또는콜론구분자() {
        String[] strings = splitter.split("a,b:c");
        assertThat(strings).isEqualTo(new String[]{"a", "b", "c"});
    }

    @Test
    void split_custom구분자() {
        String[] strings = splitter.split("//;\na;b;c");
        assertThat(strings).isEqualTo(new String[]{"a", "b", "c"});
    }
}
