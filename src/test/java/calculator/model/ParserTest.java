package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ParserTest {

    @Test
    void 기본구분자_테스트() {
        Parser parser = new Parser("1,2:3");
        assertThat(parser.getDelimiter()).isEqualTo(",|:");
    }

    @Test
    void 커스텀구분자_테스트() {
        Parser parser = new Parser("//;\n1;2;3");
        assertThat(parser.getDelimiter()).isEqualTo(";");
    }

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(final String text) {
        Parser parser = new Parser(text);
        assertThat(parser.getUserInput()).isEqualTo("0");
    }

    @Test
    void 기본구분자로_문자열_파싱하기() {
        Parser parser = new Parser("1,2:3");
        Token parsedResult = parser.parseInput();
        Token compareResult = new Token(new String[]{"1", "2", "3"});
        assertThat(compareResult).isEqualTo(parsedResult);
    }

    @Test
    void 커스텀구분자로_문자열_파싱하기() {
        Parser parser = new Parser("//;\n3;4;5");
        Token parsedResult = parser.parseInput();
        Token compareResult = new Token(new String[]{"3", "4", "5"});
        assertThat(compareResult).isEqualTo(parsedResult);
    }

}
