package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimitersTest {

    @ParameterizedTest
    @CsvSource(value = {"|, :", "' '|, :", "/|, : /"}, delimiter = '|')
    @DisplayName("주어진 문자열을 구분자로 추가합니다")
    public void addDelimiter(String input, String expected) {
        // given
        Delimiters delimiters = new Delimiters();

        // when
        delimiters.addDelimiter(input);

        // then
        assertThat(delimiters.toString()).contains(expected.split(" "));
    }

    @Test
    @DisplayName("커스텀 구분자를 추가하는 테스트")
    public void extractCustomDelimiter() {
        // given
        String expression = "//;\n1;2;3";
        Delimiters delimiters = new Delimiters();

        // when
        delimiters.extractCustomDelimiter(expression);

        // then
        assertThat(delimiters.toString()).contains(";");

    }
}