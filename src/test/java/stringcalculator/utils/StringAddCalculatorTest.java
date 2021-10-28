package stringcalculator.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
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

    @Test
    void splitAndSum_minusValue() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            StringAddCalculator.splitAndSum("10,-4,2");
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"4:4", "125:125"}, delimiter = ':')
    void splitAndSum_숫자하나(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3:6", "125,5,5:135"}, delimiter = ':')
    void splitAndSum_쉼표구분자(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3/6", "125:5,5/135"}, delimiter = '/')
    void splitAndSum_쉼표or콜론구분자(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }
}