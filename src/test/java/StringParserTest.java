import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringParserTest {
    @Test
    void 숫자만있는_String_파싱() {
        String input = "2";
        assertThat(StringParser.parseByDelimiter(input)).contains("2");
    }

    @Test
    void 구분자와_숫자를_파싱() {
        String input = "1,2";
        assertThat(StringParser.parseByDelimiter(input)).contains("1", "2");
    }
}
