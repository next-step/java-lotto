package stringcaculator.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringParserTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2|2", "1|1", "1,2|2", "1,2:3|3"}, delimiter = '|')
    void 기본_구분자_테스트(String numbers, int size) {
        String[] splitNumbers = StringParser.splitDefaultDelimiter(numbers);
        assertThat(splitNumbers.length).isEqualTo(size);
    }

    @ParameterizedTest
    @ValueSource(strings={"//;\n1;2;3", "//!\n1!2!3"})
    void 커스텀_구분자_테스트(String numbers) {
        String[] splitNumbers = StringParser.splitCustomDelimiter(numbers);
        assertThat(splitNumbers.length).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings={"//\n1;2;3", "//1!2!3"})
    void 커스텀_구분자_예외_테스트(String numbers) {
        assertThatThrownBy(() -> StringParser.splitCustomDelimiter(numbers))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
