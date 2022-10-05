package com.nextstep.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2,3", "4 - 3,1", "5 * 6,30", "10 / 3, 3"})
    @DisplayName("단순 사칙연산 테스트")
    void calculate(String polynomial, int answer) {
        assertThat(StringCalculator.calculate(polynomial)).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource(value = {"1+ 2,3", "4 // 3,1", "5 % 6,30", "d / 3, 3"})
    @DisplayName("잘못된 수식 테스트")
    void invalidPolynomials(String polynomial) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(polynomial));
    }


}