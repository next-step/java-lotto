package step1.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParserTest {

    private Parser parser;

    @BeforeEach
    void setUp() {
        this.parser = new Parser();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,1:1,1",
            "1,2,3,4:1,2,3,4",
            "2,6,3,9:2,6,3,9"}, delimiter = ':')
    @DisplayName("오류값이 없는 인풋을 파싱할 수 있다")
    void canParseValidInput(String input, String expected) {
        List<String> stringifiedExpected = Arrays.asList(expected.split(","));
        List<Integer> parsedExpected = stringifiedExpected.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        assertThat(parser.parse(input)).isEqualTo(parsedExpected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"]", "1/2", "1`5"})
    @DisplayName("오류값이 있는 인풋이 들어오면 IllegalArgumentException을 던진다")
    void canThrowExceptionOnInvalidInput(String input) {
        assertThrows(IllegalArgumentException.class,
                () -> parser.parse(input));
    }

}