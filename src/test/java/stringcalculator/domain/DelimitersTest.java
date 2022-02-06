package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimitersTest {

    @DisplayName("생성 잘 되는지")
    @Test
    void delimiter_생성_확인() {
        final List<String> expected = Arrays.asList(":", ",");
        final Delimiters delimiters = new Delimiters("");

        final String actual = delimiters.getValuesToString();

        assertThat(actual).isEqualTo(String.join("", expected));
    }
}
