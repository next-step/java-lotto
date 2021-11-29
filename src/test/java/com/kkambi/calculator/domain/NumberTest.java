package com.kkambi.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberTest {

    @DisplayName("숫자가 아닌 값을 받으면 예외를 던진다")
    @ValueSource(strings = {"*", "k", "A", ","})
    @ParameterizedTest
    void throwExceptionWhenNotNumber(String element) {
        // when
        // then
        assertThrows(RuntimeException.class, () -> new Number(element));
    }

    @DisplayName("음수를 받으면 예외를 던진다")
    @ValueSource(strings = {"-1", "-10", "-999"})
    @ParameterizedTest
    void throwExceptionWhenNegative(String element) {
        // when
        // then
        assertThrows(RuntimeException.class, () -> new Number(element));
    }
}
