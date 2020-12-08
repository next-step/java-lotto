package com.nextstep.lotto.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    private static int ZERO = 0;

    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String source) {
        int result = StringAddCalculator.splitAndSum(source);
        assertThat(result).isEqualTo(ZERO);
    }
}
