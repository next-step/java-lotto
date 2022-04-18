package me.devyonghee.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringCalculatorTest {

    @Test
    @DisplayName("객체화 불가능")
    void instance_thrownAssertionError() {
        assertThatExceptionOfType(AssertionError.class)
                .isThrownBy(() -> ReflectionUtils.newInstance(StringCalculator.class));
    }

    @Test
    void calculate() {
        assertThat(StringCalculator.from(() -> Arrays.asList("2", "+", "3", "*", "4", "/", "2")).calculate())
                .isEqualTo(Number.from("10"));
    }
}
