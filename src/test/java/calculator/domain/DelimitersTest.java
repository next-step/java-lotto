package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class DelimitersTest {

    @ParameterizedTest
    @CsvSource(value = {"|, :", "' '|, :", "/|, : /"}, delimiter = '|')
    @DisplayName("주어진 문자열을 구분자로 추가합니다")
    public void addDelimiter(String input, String expected) {
        // given
        Delimiters delimiters = new Delimiters();

        // when
        delimiters.addDelimiter(input);
        System.out.println(delimiters.toString());
        // then
        assertThat(delimiters.toString()).contains(expected.split(" "));
    }
}