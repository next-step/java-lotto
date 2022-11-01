package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    void 빈문자열() {
        assertThat(StringCalculator.calculate("")).isEqualTo(0);
    }

    @Test
    void 숫자_하나() {
        assertThat(StringCalculator.calculate("3")).isEqualTo(3);
    }

    @Test
    void 덧셈() {
        assertThat(StringCalculator.calculate("2 + 3")).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        assertThat(StringCalculator.calculate("2 - 3")).isEqualTo(-1);
        assertThat(StringCalculator.calculate("10 - 3")).isEqualTo(7);
    }

    @Test
    void 곱셈() {
        assertThat(StringCalculator.calculate("2 * 3")).isEqualTo(6);
        assertThat(StringCalculator.calculate("0 * 3")).isEqualTo(0);
    }

    @Test
    void 나눗셈() {
        assertThat(StringCalculator.calculate("10 / 2")).isEqualTo(5);
        assertThat(StringCalculator.calculate("10 / 3")).isEqualTo(3);
    }

    @Test
    void 사칙연산_섞여있을_때() {
        assertThat(StringCalculator.calculate("10 / 2 + 1 * 3 - 3")).isEqualTo(15);
        assertThat(StringCalculator.calculate("5 + 3 * 2 - 10 / 2")).isEqualTo(3);
        assertThat(StringCalculator.calculate("-5 - 3 / 2 + 10 * 2")).isEqualTo(12);
        assertThat(StringCalculator.calculate("5 * -3 - 2 + 10 * 0")).isEqualTo(0);
        assertThat(StringCalculator.calculate("-5 * -3 - -2 + -10 / -1")).isEqualTo(-7);
    }

    @Test
    void 사칙연산이_아닌_연산() {
        assertThatThrownBy(() -> StringCalculator.calculate("10 % 3"));
    }

}
