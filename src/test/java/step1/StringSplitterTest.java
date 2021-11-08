package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {

    private Pattern pattern;

    @BeforeEach
    void setUp() {
        String PATTERN_STRING = "//(.)\n(.*)";
        pattern = Pattern.compile(PATTERN_STRING);
    }

    @DisplayName("getDelimiter()는 Delimiter가 없는 경우는 empty 값의 델리미터문자열을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3|''","4;5;6|''"}, delimiter = '|')
    void getEmptyDelimiterTest(String input, String expect) {
        StringSplitter stringSplitter = StringSplitter.create(input, pattern);

        String delimiterString = stringSplitter.getCustomDelimiterSymbol();

        assertThat(delimiterString).isEqualTo(expect);

    }

    @DisplayName("getDelimiter()는 Delimiter가 있는 경우는 델리미터문자열을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1:2;3","//;\n1:2;3"})
    void getCustomDelimiterTest(String input) {
        StringSplitter stringSplitter = StringSplitter.create(input, pattern);
        String delimiterString = stringSplitter.getCustomDelimiterSymbol();

        String expect = ";";

        assertThat(delimiterString).isEqualTo(expect);
    }

    @DisplayName("getItems()는 Delimiter가 없는 경우 같은 값을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1:2;3","4:5;3"})
    void getItemStringTest(String input) {
        StringSplitter stringSplitter = StringSplitter.create(input, pattern);
        String itemString = stringSplitter.getItemString();

        assertThat(itemString).isEqualTo(input);
    }

    @DisplayName("getDelimiter()는 Delimiter가 있는 경우는 더할 문자열만 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1:2;3","//|\n1:2;3"})
    void getItemStringWithExistDelimiterTest(String input) {
        StringSplitter stringSplitter = StringSplitter.create(input, pattern);
        String itemString = stringSplitter.getItemString();

        String expect = "1:2;3";

        assertThat(itemString).isEqualTo(expect);
    }
}