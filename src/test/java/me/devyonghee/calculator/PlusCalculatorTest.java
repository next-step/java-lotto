package me.devyonghee.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("더하기 계산기")
class PlusCalculatorTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> PlusCalculator.of(() -> Number.ONE, Number.ONE));
    }

    @Test
    @DisplayName("계산기와 계산할 숫자는 필수")
    void instance_nullArgument_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> PlusCalculator.of(null, Number.ONE));
        assertThatIllegalArgumentException().isThrownBy(() -> PlusCalculator.of(() -> Number.ONE, null));
    }

    @Test
    @DisplayName("계산")
    void calculatedNumber() {
        assertThat(PlusCalculator.of(() -> Number.ONE, Number.ONE).calculatedNumber()).isEqualTo(Number.from("2"));
    }
}
