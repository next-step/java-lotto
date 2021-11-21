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
        assertThat(parser.getDelimiterFrom(emptyText)).isEqualTo(",|:");
        assertThat(parser.getDelimiterFrom(customSemicolonText)).isEqualTo(",|:|;");
        assertThat(parser.getDelimiterFrom(customMinusText)).isEqualTo(",|:|-");
    }

    @Test
    void getTextFrom() {
        assertThat(parser.getTextFrom(emptyText)).isEqualTo("");
        assertThat(parser.getTextFrom(customSemicolonText)).isEqualTo("1,2:3;4");
        assertThat(parser.getTextFrom(customMinusText)).isEqualTo("1-2");
    }

}
