package com.jaeyeonling.calculate.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @DisplayName("null 이나 빈 값 입력 시 true")
    @ParameterizedTest
    @NullAndEmptySource
    void should_return_true_when_nullAndBlank(final String source) {
        final boolean isNullOrBlank = StringUtils.isNullOrBlank(source);
        assertThat(isNullOrBlank).isTrue();
    }

    @DisplayName("값 입력 시 false")
    @ParameterizedTest
    @ValueSource(strings = {
            "asdasds",
            "sadasd!!!"
    })
    void should_return_false_when_value(final String source) {
        final boolean isNullOrBlank = StringUtils.isNullOrBlank(source);
        assertThat(isNullOrBlank).isFalse();
    }

}
