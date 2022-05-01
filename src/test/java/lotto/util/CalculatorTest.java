package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    @DisplayName("1 나누기 4를 하면 0.25가 반환된다.")
    void divide() {
        assertThat(Calculator.divide(1, 4)).isEqualTo("0.25");
    }
}