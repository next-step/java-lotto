package stringaddcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MessageParserTest {
    private MessageParser messageParser;

    @BeforeEach
    public void setup() {
        messageParser = new MessageParser();
    }

    @Test
    public void parseTest() {
        String inputMessage = "//;\n1;2;3";
        String delimiter = ";";
        Message message = messageParser.parse(inputMessage);
        Assertions.assertThat(message).isEqualTo(new Message(delimiter, "1;2;3"));
    }

    @Test
    public void doseNotHaveCustomDelimiterParseTest() {
        String inputMessage = "1;2;3";
        Message message = messageParser.parse(inputMessage);
        Assertions.assertThat(message).isEqualTo(new Message(null, "1;2;3"));
    }

}
