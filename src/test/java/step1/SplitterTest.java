package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {

    @DisplayName(",으로 나눈다")
    @Test
    void split_with_comma() {
        Splitter splitter = new Splitter();
        String[] numbers = splitter.split("1,2");
        assertThat(numbers).contains("1");
    }

    @DisplayName(":으로 나눈다")
    @Test
    void split_with_colon() {
        Splitter splitter = new Splitter();
        String[] numbers = splitter.split("1,2");
        assertThat(numbers).contains("1");
    }

    @Test
    void get_custom_delimiter() {
        Splitter splitter = new Splitter();
        String delimiter = splitter.getDelimiter("//;\n1;2","//(.)\n(.*)",1);
        assertThat(delimiter).isEqualTo(";");
    }
}
