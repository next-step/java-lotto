package me.devyonghee.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("곱하기 계산기")
class MultiplyCalculatorTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> MultiplyCalculator.of(() -> Number.ONE, Number.ONE));
    }

    @Test
    @DisplayName("계산기와 계산할 숫자는 필수")
    void instance_nullArgument_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> MultiplyCalculator.of(null, Number.ONE));
        assertThatIllegalArgumentException().isThrownBy(() -> MultiplyCalculator.of(() -> Number.ONE, null));
    }

    @Test
    @DisplayName("계산")
    void calculate() {
        assertThat(MultiplyCalculator.of(() -> Number.ONE, Number.ZERO).calculate()).isEqualTo(Number.ZERO);
        assertThat(MultiplyCalculator.of(() -> Number.ONE, Number.ONE).calculate()).isEqualTo(Number.ONE);
    }
}
