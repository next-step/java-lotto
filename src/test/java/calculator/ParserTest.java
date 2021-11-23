package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {

    private final Parser parser = new Parser();

    private final String emptyText = "";
    private final String customSemicolonText = "//;\n1,2:3;4";
    private final String customMinusText = "//-\n1-2";

    @Test
    void getRegexFrom() {
        assertThat(parser.extractDelimiterFrom(emptyText)).isEqualTo(Parser.DELIMITERS);
        assertThat(parser.extractDelimiterFrom(customSemicolonText)).isEqualTo(Parser.DELIMITERS + "|;");
        assertThat(parser.extractDelimiterFrom(customMinusText)).isEqualTo(Parser.DELIMITERS + "|-");
    }

    @Test
    void getTextFrom() {
        assertThat(parser.extractTextFrom(emptyText)).isEqualTo("");
        assertThat(parser.extractTextFrom(customSemicolonText)).isEqualTo("1,2:3;4");
        assertThat(parser.extractTextFrom(customMinusText)).isEqualTo("1-2");
    }

}
