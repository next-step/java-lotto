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
    void 더하기_계산() {
        StringCalculator stringCalculator = new StringCalculator("1 + 2");

        int result = stringCalculator.result();

        assertThat(result).isEqualTo(3);
    }

    @Test
    void 빼기_계산() {
        StringCalculator stringCalculator = new StringCalculator("10 - 2");

        int result = stringCalculator.result();

        assertThat(result).isEqualTo(8);
    }

    @Test
    void 곱하기_계산() {
        StringCalculator stringCalculator = new StringCalculator("10 * 2");

        int result = stringCalculator.result();

        assertThat(result).isEqualTo(20);
    }

    @Test
    void 나누기_계산() {
        StringCalculator stringCalculator = new StringCalculator("10 / 2");

        int result = stringCalculator.result();

        assertThat(result).isEqualTo(5);
    }

    @Test
    void 전체_계산() {
        StringCalculator stringCalculator = new StringCalculator("2 + 3 * 4 / 2");

        int result = stringCalculator.result();

        assertThat(result).isEqualTo(10);
    }

}
