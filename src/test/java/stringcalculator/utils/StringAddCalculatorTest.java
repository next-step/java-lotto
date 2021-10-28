package stringcalculator.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullSource
    @EmptySource
    void splitAndSum_emptyOfNull(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:4", "125:125"}, delimiter = ':')
    void splitAndSum_숫자하나(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

}