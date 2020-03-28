package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    void calculate_inputIsEmpty_return0() {
        int result = StringAddCalculator.calculate("");
        assertThat(result).isZero();

        result = StringAddCalculator.calculate(null);
        assertThat(result).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "5", "22"})
    void calculate_inputOneNumber_returnOrigin(String input) {
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isEqualTo(Integer.valueOf(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3/6", "1:5,4/10", "3,5:9/17"}, delimiter = '/')
    void calculate_inputDelimiters_returnSum(String input, int expected) {
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"//;#1;2;3|6", "//-#4-9-3|16"}, delimiter = '|')
    void calculate_inputCustomDelimiter_returnSum(String input, int expected) {
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }
}
