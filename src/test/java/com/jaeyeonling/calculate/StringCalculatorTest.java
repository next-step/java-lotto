package com.jaeyeonling.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @DisplayName("빈 값을 입력 시 0을 반환한다.")
    @Test
    void should_return_zero_when_empty() {
        final int returnValue = StringCalculator.add("");

        assertThat(returnValue).isEqualTo(0);
    }

}
