package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    @Test
    public void split_null() {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.split(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    public void split_빈공백문자(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.split(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "1 3:2", "-1 + 1:3", "2 + 3 * 4 / 2:7"}, delimiter = ':')
    public void split(String text, int expectedSize) {
        List<String> resultList = StringCalculator.split(text);
        assertThat(resultList.isEmpty()).isFalse();

        assertThat(resultList).hasSize(expectedSize);
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    public void isVaildOperator(String operator) {
        assertThat(StringCalculator.isValidOperator(operator)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"%", "x", "X", "="})
    public void isVaildOperator_유효하지않은_연산자(String operator) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.isValidOperator(operator));
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "1 + 3 + 5:9", "-1 + 0 + 1 + 2:2"}, delimiter = ':')
    public void sum(String text, int expected) {
        int result = StringCalculator.calculate(text);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 - 2:-1", "1 - 3 - 5:-7", "10 - 2:8"}, delimiter = ':')
    public void sub(String text, int expected) {
        int result = StringCalculator.calculate(text);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 * 2:2", "1 * 3 * 5:15", "-1 * 0 * 1 * 2:0"}, delimiter = ':')
    public void multi(String text, int expected) {
        int result = StringCalculator.calculate(text);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 / 1:2", "4 / 2:2", "4 / 2 / 2:1"}, delimiter = ':')
    public void divide(String text, int expected) {
        int result = StringCalculator.calculate(text);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2 + 3 * 4 / 2 - 5:5"}, delimiter = ':')
    public void mixed_operator(String text, int expected) {
        int result = StringCalculator.calculate(text);

        assertThat(result).isEqualTo(expected);
    }
}
