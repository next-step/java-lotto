package calculator.delimiter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringDelimiterTest {

    @Test
    @DisplayName("기본 구분자를 포함한 문자열 분리 테스트")
    void split_by_default_delimiter_test() {
        // given
        String text = "1,2:3";

        // when
        String[] result = StringDelimiter.splitByDelimiter(text);

        // then
        assertEquals(3, result.length);
    }

    @Test
    @DisplayName("커스텀 구분자를 포함한 문자열 분리 테스트")
    void split_by_custom_delimiter_test() {
        // given
        String text = "//;\n1;2;3";

        // when
        String[] result = StringDelimiter.splitByDelimiter(text);

        // then
        assertEquals(3, result.length);
    }

}
