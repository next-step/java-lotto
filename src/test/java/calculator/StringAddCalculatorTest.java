package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class StringAddCalculatorTest {
    @Test
    void 입력값이_빈문자열일경우_예외처리() {
        String value = " ";
        assertThatThrownBy(() -> StringAddCalculator.splitAndCalculate(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값이_nulll_일경우_예외처리() {
        String value = null;
        assertThatThrownBy(() -> StringAddCalculator.splitAndCalculate(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}