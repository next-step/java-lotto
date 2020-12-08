package com.nextstep.lotto.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    private static int ZERO = 0;

    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String source) {
        int result = StringAddCalculator.splitAndSum(source);
        assertThat(result).isEqualTo(ZERO);
    }

    @ParameterizedTest
    @CsvSource({"1,1", "3,3"})
    public void splitAndSum_숫자하나(String source, int expected) {
        int result = StringAddCalculator.splitAndSum(source);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"'1,2',3", "'5,3',8"})
    public void splitAndSum_쉼표구분자(String source, int expected) {
        int result = StringAddCalculator.splitAndSum(source);
        assertThat(result).isEqualTo(expected);
    }
}
