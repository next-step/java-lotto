package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String text) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "10:10", "5:5"}, delimiter = ':')
    public void splitAndSum_숫자하나(String inputText, int resultNum) throws Exception {
        int result = StringAddCalculator.splitAndSum(inputText);
        assertThat(result).isEqualTo(resultNum);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "1,2,5:8", "4,5,2:11"}, delimiter = ':')
    public void splitAndSum_쉼표구분자(String numbers, int resultSum) throws Exception {
        int result = StringAddCalculator.splitAndSum(numbers);
        assertThat(result).isEqualTo(resultSum);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3|6", "1:2,5:8|16", "4:5:2:11|22"}, delimiter = '|')
    public void splitAndSum_쉼표_또는_콜론_구분자(String numbers, int resultSum) throws Exception {
        int result = StringAddCalculator.splitAndSum(numbers);
        assertThat(result).isEqualTo(resultSum);
    }

    @ParameterizedTest
    @CsvSource(value = {"//;|1;2;3|6", "//;|12,2;3|17", "//;|''|0"}, delimiter = '|')
    public void splitAndSum_custom_구분자(String customDelimiter, String numbers, int resultSum) throws Exception {
        String inputText = customDelimiter + "\n" + numbers;
        int result = StringAddCalculator.splitAndSum(inputText);
        assertThat(result).isEqualTo(resultSum);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "a,b,c", "a1,2,3"})
    public void splitAndSum_negative(String inputText) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(inputText))
                .isInstanceOf(RuntimeException.class);
    }
}
