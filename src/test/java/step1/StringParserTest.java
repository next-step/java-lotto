package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringParserTest {

    private StringParser stringParser;

    @BeforeEach
    void init() {
        stringParser = new StringParser();
    }

    @DisplayName("분할 테스트")
    @Test
    void parse() {
        //given
        String input = "//t\n1;2;3";
        String delimiter = stringParser.setDelimiter(input);

        //when
        String[] stringNumbers = stringParser.parse(delimiter);

        //then
        assertThat(stringNumbers).contains("1", "2", "3");
    }

    @DisplayName("구분자 설정 테스트")
    @Test
    void setDelimiter() {
        //given
        String input = "//t\n1;2;3";

        //when
        String delimiter = stringParser.setDelimiter(input);

        //then
        assertThat(delimiter).isEqualTo("t|;|,");
    }

}