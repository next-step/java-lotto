package calculator.util;

import lotto.util.StringNumberUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StringNumberUtilsTest {
    @ParameterizedTest
    @CsvSource(value = {
            "-5, -5",
            "-1, -1",
            "0, 0",
            "1, 1",
            "5, 5",
            "+1, +1",
            "+5, +5"
    })
    void parse_숫자인_경우(String stringNumber, int number) {
        assertThat(StringNumberUtils.parse(stringNumber)).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "abc", "%", "-", "1-1", "*", "/"})
    void parse_숫자가_아닌_경우(String nonNumber) {
        assertThatThrownBy(() -> StringNumberUtils.parse(nonNumber));
    }
}