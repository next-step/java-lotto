package me.devyonghee.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("나누기 계산기")
class DivideCalculatorTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> DivideCalculator.of(() -> Number.ONE, Number.ONE));
    }

    @Test
    @DisplayName("계산기와 계산할 숫자는 필수")
    void instance_nullArgument_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> DivideCalculator.of(null, Number.ONE));
        assertThatIllegalArgumentException().isThrownBy(() -> DivideCalculator.of(() -> Number.ONE, null));
    }

    @Test
    @DisplayName("나누는 값이 0이면 안됨")
    void instance_zeroValue_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> DivideCalculator.of(() -> Number.ONE, Number.ZERO))
                .withMessage("number to divide cannot be zero");
    }

    @Test
    @DisplayName("계산")
    void calculatedNumber() {
        assertThat(DivideCalculator.of(() -> Number.ZERO, Number.ONE).calculatedNumber()).isEqualTo(Number.ZERO);
        assertThat(DivideCalculator.of(() -> Number.ONE, Number.ONE).calculatedNumber()).isEqualTo(Number.ONE);
    }
}
