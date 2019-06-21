package com.jaeyeonling.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @DisplayName("null 이나 빈 값 입력 시 0")
    @ParameterizedTest
    @NullAndEmptySource
    void should_return_zero_when_null_or_blank(final String source) {
        final int result = StringAddCalculator.execute(source);

        assertThat(result).isEqualTo(0);
    }

}
