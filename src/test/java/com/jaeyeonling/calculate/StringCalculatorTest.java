package com.jaeyeonling.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @DisplayName("빈 값을 입력 시 0을 반환한다.")
    @Test
    void should_return_zero_when_empty() {
        final int returnValue = StringCalculator.add("");

        assertThat(returnValue).isEqualTo(0);
    }

    @DisplayName("쉼표를 또는 콜론을 구분자로 가지는 문자열 입력 시 합을 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "'1,2',3"
    })
    void should_expected_sum_when_add(final String expression, final int expected) {
        final int returnValue = StringCalculator.add(expression);

        assertThat(returnValue).isEqualTo(expected);
    }

}
