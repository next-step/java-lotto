package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {

    @DisplayName(",으로 나눈다")
    @Test
    void split() {
        Splitter splitter = new Splitter();
        String[] numbers = splitter.split("1,2");
        assertThat(numbers).contains("1");
    }

    @Test
    void convert_string_to_number() {
        Splitter splitter = new Splitter();
        String[] list = {"1","2"};
        List<Number> numbers = splitter.parseNumber(list);
        assertThat(numbers).contains(new Number("1"));
    }
}
