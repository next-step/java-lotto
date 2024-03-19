package caculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TextParserTest {
    private TextParser textParser;

    @BeforeEach
    void setUp() {
        textParser = new TextParser();
    }

    @Test
    @DisplayName("입력된 문자열을 공백문자 기준으로 파싱한다.")
    void textParse() {
        String text = "1 / 4 * 10";
        List<String> result = textParser.textToStringList(text);

        assertThat(result).containsExactly("1", "/", "4", "*", "10");
    }
}
