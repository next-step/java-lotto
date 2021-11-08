package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringSplitterTest {

    private Pattern pattern;

    @BeforeEach
    void setUp() {
        String PATTERN_STRING = "//(.)\n(.*)";
        pattern = Pattern.compile(PATTERN_STRING);
    }

    @DisplayName("getDelimiter()는 Delimiter가 없는 경우는 empty 값의 델리미터가 생성된다.")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3|''","4;5;6|''"}, delimiter = '|')
    void getDelimiterTest(String input, String symbol) {
        StringSplitter stringSplitter = StringSplitter.create(input, pattern);
        Delimiter delimiter = stringSplitter.getDelimiter();

        Delimiter expectDelimiter = Delimiter.custom(symbol);

        assertThat(delimiter).isEqualTo(expectDelimiter);
    }

    @DisplayName("getDelimiter()는 Delimiter가 있는 경우는 델리미터가 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1:2;3","//;\n1:2;3"})
    void getTDelimiterTest(String input) {
        StringSplitter stringSplitter = StringSplitter.create(input, pattern);
        Delimiter delimiter = stringSplitter.getDelimiter();

        Delimiter expectDelimiter = Delimiter.custom(";");

        assertThat(delimiter).isEqualTo(expectDelimiter);
    }
}