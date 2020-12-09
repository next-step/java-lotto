package com.nextstep.calculator;

import com.nextstep.calculator.domain.Number;
import com.nextstep.calculator.domain.exceptions.InvalidNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {
    @DisplayName("문자열을 인자로 받아 값 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        String value = "12930";

        Number number = Number.of(value);

        assertThat(number).isNotNull();
        assertThat(number).isEqualTo(Number.of(value));
    }

    @DisplayName("입력값이 잘못된 경우 예외 발생")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "  "})
    void createFailByInvalidValue(String invalidValue) {
        assertThatThrownBy(() -> Number.of(invalidValue)).isInstanceOf(InvalidNumberException.class);
    }

    @DisplayName("양수로 변환할 수 없을 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "sdnqkldq"})
    void parseFailTest(String notPositiveNumber) {
        assertThatThrownBy(() -> Number.of(notPositiveNumber)).isInstanceOf(InvalidNumberException.class);
    }

    @DisplayName("Number 객체 간 더하기가 가능하다.")
    @Test
    void plusTest() {
        Number ONE = Number.of("1");
        Number ZERO = Number.of("0");

        assertThat(ONE.plus(ZERO)).isEqualTo(ONE);
    }
}
