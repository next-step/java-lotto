package com.nextstep.lotto.stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 공백 연산자일 때 IllegalArgumentException throw")
    void nullOrEmptyOperator(String polynomial) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(polynomial));
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2,3", "4 - 3,1", "5 * 6,30", "10 / 3, 3", "-3 * +2, -6"})
    @DisplayName("단순 사칙연산 테스트")
    void calculate(String polynomial, int answer) {
        assertThat(StringCalculator.calculate(polynomial)).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource(value = {"1+ 2", "4 // 3", "5 % 6", "d / 3"})
    @DisplayName("잘못된 수식 테스트")
    void invalidPolynomials(String polynomial) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(polynomial));
    }


}