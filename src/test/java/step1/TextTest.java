package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TextTest {

    @DisplayName(",으로 나눈다")
    @Test
    void split() {
        Text text = new Text("1,2");
        String[] numbers = text.split(",");
        assertThat(numbers).contains("1");
    }

    @Test
    void convert_string_to_number() {
        Text text = new Text("1,2");
        String[] list = {"1","2"};
        List<Number> numbers = text.parseNumber(list);
        assertThat(numbers).contains(new Number("1"));
    }
}
