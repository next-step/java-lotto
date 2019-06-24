package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringParserTest {
    @Test
    @DisplayName("숫자만 있는 스트링을 파싱")
    void parseByDelimiter() {
        String input = "2";
        StringParser stringParser = new StringParser(input);
        assertThat(stringParser.parseByDelimiter()).contains("2");
    }

    @Test
    @DisplayName("컴마 구분자가 있는 스트링 파싱")
    void parseByDelimiter2() {
        String input = "1,2";
        StringParser stringParser = new StringParser(input);
        assertThat(stringParser.parseByDelimiter()).contains("1", "2");
    }

    @Test
    @DisplayName("콜론 구분자가 있는 스트링 파싱")
    void parseByDelimiter3() {
        String input = "1:2";
        StringParser stringParser = new StringParser(input);
        assertThat(stringParser.parseByDelimiter()).contains("1", "2");
    }

    @Test
    @DisplayName("컴마, 콜론 구분자가 있는 스트링 파싱")
    void parseByDelimiter4() {
        String input = "1,2,3:4:5";
        StringParser stringParser = new StringParser(input);
        assertThat(stringParser.parseByDelimiter()).contains("1", "2", "3", "4", "5");
    }

    @Test
    @DisplayName("입력받은 스트링에서 구분자가 있으면 파싱한다")
    void parseAdditionalDelimiter() {
        String input = "//;\n1;2;3";
        StringParser stringParser = new StringParser(input);
        assertThat(stringParser.parseByDelimiter()).contains("1", "2", "3");
    }
}
