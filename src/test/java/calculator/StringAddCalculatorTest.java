package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("null 이거나 빈값으로 계산 시 return 0")
    void calculate_inputIsEmpty_return0() {
        int result = StringAddCalculator.calculate("");
        assertThat(result).isZero();

        result = StringAddCalculator.calculate(null);
        assertThat(result).isZero();
    }

    @ParameterizedTest
    @DisplayName("숫자 하나로 계산 시 return 입력 값")
    @ValueSource(strings = {"0", "5", "22"})
    void calculate_inputOneNumber_returnOrigin(String input) {
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isEqualTo(Integer.valueOf(input));
    }

    @ParameterizedTest
    @DisplayName(":나 /를 구분자로 숫자 합계 계산")
    @CsvSource(value = {"1,2,3/6", "1:5,4/10", "3,5:9/17"}, delimiter = '/')
    void calculate_inputDelimiters_returnSum(String input, int expected) {
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자로 숫자 합계 계산")
    @CsvSource(value = {"//;#1;2;3|6", "//-#4-9-3|16"}, delimiter = '|')
    void calculate_inputCustomDelimiter_returnSum(String input, int expected) {
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }
}
