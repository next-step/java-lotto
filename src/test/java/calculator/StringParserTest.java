package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2,3"})
    void 기본_구분자_파싱(String text) {
        assertThat(StringParser.parse(text)).containsExactly("1", "2", "3");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//!\n1!2!3"})
    void 커스텀_구분자_파싱(String text) {
        assertThat(StringParser.parse(text)).containsExactly("1", "2", "3");
    }
}
