import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeaderParserTest {
    private HeaderParser headerParser;

    @BeforeEach
    public void setup() {
        headerParser = new HeaderParser();
    }

    @Test
    public void parseHeaderTest() {
        String message = "//;\n1;2;3";
        String delimiter = ";";
        headerParser.parseHeader(message);
        assertThat(headerParser.getDelimiter()).isEqualTo(delimiter);
    }

    @Test
    public void doseNotHaveCustomDelimiterParseHeaderTest() {
        String message = "1;2;3";
        headerParser.parseHeader(message);
        assertThat(headerParser.getDelimiter()).isEqualTo(null);
        assertThat(headerParser.getMessageBody()).isEqualTo(message);
    }
}
