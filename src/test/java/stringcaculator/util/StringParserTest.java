package stringcaculator.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringParserTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2|2", "1|1", "1,2|2", "1,2:3|3"}, delimiter = '|')
    void 기본_구분자_테스트(String numbers, int size) {
        String[] splitNumbers = StringParser.splitDefaultDelimiter(numbers);
        assertThat(splitNumbers.length).isEqualTo(size);
    }
}
