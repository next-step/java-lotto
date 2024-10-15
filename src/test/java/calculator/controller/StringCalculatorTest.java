package calculator.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @Test
    void 빈값_검증() {
        assertThatThrownBy(() -> new StringCalculator("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void null_검증() {
        assertThatThrownBy(() -> new StringCalculator(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 전체_계산() {
        StringCalculator stringCalculator = new StringCalculator("2 + 3 * 4 / 2");

        int result = stringCalculator.result();

        assertThat(result).isEqualTo(10);
    }

}
