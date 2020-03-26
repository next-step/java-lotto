package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterTest {

    @DisplayName("컴마(,), 콜론(:) 기준으로 문자열을 분리할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1:2", "1,2:3"})
    void splitFromComma(String input) {
        final String[] expect = input.split(",|:");

        String[] splitInput = Delimiter.split(input);

        assertThat(splitInput).isEqualTo(expect);
    }


    @DisplayName("커스텀 구분자로 문자열을 분리한다.")
    @Test
    void splitFromCustomDelimiter() {
        final String input = "//;\n1;2;3";
        final String[] expect = new String[]{"1", "2", "3"};

        String[] splitInput = Delimiter.split(input);

        assertThat(splitInput).isEqualTo(expect);
    }
}