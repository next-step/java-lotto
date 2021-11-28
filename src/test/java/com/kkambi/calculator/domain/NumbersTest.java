package com.kkambi.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumbersTest {

    @DisplayName("숫자 형식의 문자열 리스트를 받아 생성된다")
    @Test
    void createNumbersWithNumberList() {
        // given
        String[] elements = {"1", "2", "3"};

        // when
        assertThat(new Numbers(elements).getNumbers())
                .containsExactlyElementsOf(Arrays.asList(1, 2, 3));
    }

    @DisplayName("숫자가 아닌 값을 받으면 예외를 던진다")
    @ValueSource(strings = {"*", "k", "A", ","})
    @ParameterizedTest
    void throwExceptionWhenNotNumber(String element) {
        // given
        String[] elements = {element};

        // when
        // then
        assertThrows(RuntimeException.class, () -> new Numbers(elements));
    }

    @DisplayName("음수를 받으면 예외를 던진다")
    @ValueSource(strings = {"-1", "-10", "-999"})
    @ParameterizedTest
    void throwExceptionWhenNegative(String element) {
        // given
        String[] elements = {element};

        // when
        // then
        assertThrows(RuntimeException.class, () -> new Numbers(elements));
    }
}