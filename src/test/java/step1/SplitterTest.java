package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {

    @DisplayName(",으로 나누어 String 배열을 반환한다")
    @Test
    void split_with_comma() {
        Splitter splitter = new Splitter();
        String[] numbers = splitter.split("1,2");
        assertThat(numbers).contains("1");
    }

    @DisplayName(":으로 나누어 String 배열을 반환한다")
    @Test
    void split_with_colon() {
        Splitter splitter = new Splitter();
        String[] numbers = splitter.split("1:2");
        assertThat(numbers).contains("1");
    }

    @DisplayName(", 혹은 :으로 나누어 String 배열을 반환한다")
    @Test
    void split_with_colon_and_comma() {
        Splitter splitter = new Splitter();
        String[] numbers = splitter.split("1,4:2");
        assertThat(numbers).contains("1");
    }

    @DisplayName("custom 구분자로 나누어 String 배열을 반환한다")
    @Test
    void get_custom_delimiter() {
        Splitter splitter = new Splitter();
        String[] splitText = splitter.getCustomSplitText("//;\n1;2");
        assertThat(splitText).isEqualTo(new String[]{"1", "2"});
    }
}
