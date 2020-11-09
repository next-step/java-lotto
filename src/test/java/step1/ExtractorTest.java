package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExtractorTest {

    @Test
    void extractCustomDelimiter() {
        String input = "//;\n1;2;3";
        String result = Extractor.extractCustomDelimiter(input);
        String expected = ";";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void extractNums() {
        String input = "//;\n1;2;3";
        String result = Extractor.extractNums(input);
        String expected = "1;2;3";
        assertThat(result).isEqualTo(expected);
    }
}
