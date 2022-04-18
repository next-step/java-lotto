package me.devyonghee.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.platform.commons.util.ReflectionUtils;

import static org.assertj.core.api.Assertions.*;

@DisplayName("계산 유틸")
class CalculationUtilsTest {

    @Test
    @DisplayName("객체화 불가능")
    void instance_thrownAssertionError() {
        assertThatExceptionOfType(AssertionError.class)
                .isThrownBy(() -> ReflectionUtils.newInstance(CalculationUtils.class));
    }

    @Test
    @DisplayName("문자열로된 숫자 계산")
    void calculate() {
        assertThat(CalculationUtils.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @ParameterizedTest
    @DisplayName("빈 문자열은 계산 불가")
    @NullAndEmptySource
    void calculate(String nullOrEmpty) {
        assertThatIllegalArgumentException().isThrownBy(() -> CalculationUtils.calculate(nullOrEmpty));
    }
}
