package me.devyonghee.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

@DisplayName("문자열 계산기")
class StringCalculatorTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> StringCalculator.from(() -> Collections.singletonList("1")));
    }

    @Test
    @DisplayName("문자열 제공자는 필수")
    void instance_nullArgument_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.from(null));
    }

    @Test
    @DisplayName("문자열 계산")
    void calculatedNumber() {
        assertThat(StringCalculator.from(() -> Arrays.asList("2", "+", "3", "*", "4", "/", "2")).calculatedNumber())
                .isEqualTo(Number.from("10"));
    }

    @Test
    @DisplayName("한개의 문자로된 숫자인 경우 그대로 반환")
    void calculatedNumber_single() {
        assertThat(StringCalculator.from(() -> Collections.singletonList("1")).calculatedNumber())
                .isEqualTo(Number.ONE);
    }

    @Test
    @DisplayName("연산을 계산할 숫자는 필수")
    void calculatedNumber_notExistNumber_thrownIllegalStateException() {
        assertThatIllegalStateException().isThrownBy(() -> StringCalculator.from(() -> Arrays.asList("2", "+")).calculatedNumber());
    }
}
