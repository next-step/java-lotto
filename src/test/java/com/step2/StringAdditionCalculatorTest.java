package com.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAdditionCalculatorTest {
    @DisplayName("기본 구분자 계산 숫자 하나")
    @Test
    void basic_separator_test_숫자_하나() {
        int result = StringAdditionCalculator.calculateAddition("3");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("기본 구분자 계산 숫자 세 개")
    @Test
    void basic_separator_test_숫자_세개() {
        int result = StringAdditionCalculator.calculateAddition("3,2:1");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("기본 구분자 계산 숫자 Null or Empty")
    @Test
    void basic_separator_test_숫자_Null_Empty() {
        int result1 = StringAdditionCalculator.calculateAddition("");
        assertThat(result1).isEqualTo(0);

        int result2 = StringAdditionCalculator.calculateAddition(null);
        assertThat(result2).isEqualTo(0);
    }

    @DisplayName("커스텀 구분자 계산 숫자 하나")
    @Test
    void custom_separator_test_숫자_하나() {
        int result1 = StringAdditionCalculator.calculateAddition("//;\n3");
        assertThat(result1).isEqualTo(3);
    }

    @DisplayName("커스텀 구분자 계산 숫자 세 개")
    @Test
    void custom_separator_test_숫자_세개() {
        int result1 = StringAdditionCalculator.calculateAddition("//;\n3;2;1");
        assertThat(result1).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자 계산 숫자 empty")
    @Test
    void custom_separator_test_숫자_Empty() {
        int result1 = StringAdditionCalculator.calculateAddition("//;\n");
        assertThat(result1).isEqualTo(0);
    }

    @DisplayName("음수 예외 발생 테스트")
    @Test
    void negative_exception() {
        assertThatThrownBy(() -> StringAdditionCalculator.calculateAddition("-3,2:1"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자 이외의 문자 포함 예외 테스트")
    @Test
    void text_exception() {
        assertThatThrownBy(() -> StringAdditionCalculator.calculateAddition("3,*:1"))
                .isInstanceOf(RuntimeException.class);
    }
}
