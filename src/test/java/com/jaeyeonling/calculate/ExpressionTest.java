package com.jaeyeonling.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ExpressionTest {

    @DisplayName("빈 값을 입력 시 0을 반환한다.")
    @Test
    void should_return_zero_when_empty() {
        final int returnValue = Expression.of("").execute();

        assertThat(returnValue).isEqualTo(0);
    }

    @DisplayName("쉼표를 또는 콜론을 구분자로 가지는 문자열 입력 시 합을 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "'1,2',3",
            "'1:2',3",
            "'1:2,3',6"
    })
    void should_expected_sum_when_add(final String expression, final int expected) {
        final int returnValue = Expression.of(expression).execute();

        assertThat(returnValue).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자로 문자열 입력 시 합을 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "'//;\n1;2;3',6",
            "'//a\n1a2a3a4',10",
            "'//Q\n1Q2Q3Q4Q10',20",
    })
    void should_expected_sum_when_custom_separator_add(final String expression, final int expected) {
        final int returnValue = Expression.of(expression).execute();

        assertThat(returnValue).isEqualTo(expected);
    }
}
