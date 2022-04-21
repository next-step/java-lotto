package me.devyonghee.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("빼기 계산기")
class MinusCalculatorTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> MinusCalculator.of(() -> Number.ONE, Number.ONE));
    }

    @Test
    @DisplayName("계산기와 계산할 숫자는 필수")
    void instance_nullArgument_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> MinusCalculator.of(null, Number.ONE));
        assertThatIllegalArgumentException().isThrownBy(() -> MinusCalculator.of(() -> Number.ONE, null));
    }

    @Test
    @DisplayName("계산")
    void calculatedNumber() {
        assertThat(MinusCalculator.of(() -> Number.ONE, Number.ONE).calculatedNumber()).isEqualTo(Number.ZERO);
    }
}
