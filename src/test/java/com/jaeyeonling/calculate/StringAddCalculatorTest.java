package com.jaeyeonling.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @DisplayName("null 이나 빈 값 입력 시 0")
    @ParameterizedTest
    @NullAndEmptySource
    void should_return_zero_when_null_or_blank(final String source) {
        final int result = StringAddCalculator.execute(source);

        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나 입력 시 값 그대로 응답")
    @ParameterizedTest
    @ValueSource(strings = {
            "1",
            "2",
            "14",
            "2123112"
    })
    void should_return_inputValue_when_oneValue(final String source) {
        final int result = StringAddCalculator.execute(source);
        final int expected = Integer.parseInt(source);

        assertThat(result).isEqualTo(expected);
    }


}
