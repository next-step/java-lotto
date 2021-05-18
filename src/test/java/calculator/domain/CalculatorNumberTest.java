package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorNumberTest {
    @Test
    @DisplayName("음수를 가지면 Exception이 발생한다")
    public void 음수를_가지면_Exception을_발생한다() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new CalculatorNumber("-1"));
    }
}