package com.jaeyeonling.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ExpressionValidatorTest {

    @DisplayName("음수를 전달하는 경우 RuntimeException 예외를 throw 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,-3"
    })
    void should_throw_RuntimeException_when_negative(final String expression) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> ExpressionValidator.validate(expression));
    }
}
