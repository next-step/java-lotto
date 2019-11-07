package com.calc.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CustomDelimiterTest {

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3"})
    @DisplayName("사용자 구분자의 유무 확인")
    void findDelimiterTest(String inputValue) {
        CustomDelimiter customDelimiter = new CustomDelimiter();
        assertThat(customDelimiter.hasCustomDelimiter(inputValue)).isTrue();
    }
}