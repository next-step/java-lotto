package StringCalculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    @Test
    @DisplayName("덧셈 테스트")
    void addtion() {
        assertAll(
                () -> assertThat(StringCalculator.calculate("1 + 1")).isEqualTo(2),
                () -> assertThat(StringCalculator.calculate("2 + 2")).isEqualTo(4),
                () -> assertThat(StringCalculator.calculate("4 + 1")).isEqualTo(5),
                () -> assertThat(StringCalculator.calculate("0 + 8")).isEqualTo(8),
                () -> assertThat(StringCalculator.calculate("-2 + 22")).isEqualTo(20),
                () -> assertThat(StringCalculator.calculate("-2 + 2 + 3 + 5")).isEqualTo(8)
        );
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtraction() {
        assertAll(
                () -> assertThat(StringCalculator.calculate("1 - 1")).isEqualTo(0),
                () -> assertThat(StringCalculator.calculate("2 - 4")).isEqualTo(-2),
                () -> assertThat(StringCalculator.calculate("4 - 1")).isEqualTo(3),
                () -> assertThat(StringCalculator.calculate("0 - 8")).isEqualTo(-8),
                () -> assertThat(StringCalculator.calculate("-2 - 22")).isEqualTo(-24),
                () -> assertThat(StringCalculator.calculate("30 - 22 - 1 - 3")).isEqualTo(4)
        );
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void division() {
        assertAll(
                () -> assertThat(StringCalculator.calculate("1 / 1")).isEqualTo(1),
                () -> assertThat(StringCalculator.calculate("2 / 2")).isEqualTo(1),
                () -> assertThat(StringCalculator.calculate("4 / 1")).isEqualTo(4),
                () -> assertThat(StringCalculator.calculate("4 / 2")).isEqualTo(2),
                () -> assertThat(StringCalculator.calculate("22 / -2")).isEqualTo(-11),
                () -> assertThat(StringCalculator.calculate("8 / -2 / 4")).isEqualTo(-1)
        );
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiplication() {
        assertAll(
                () -> assertThat(StringCalculator.calculate("1 * 1")).isEqualTo(1),
                () -> assertThat(StringCalculator.calculate("2 * 2")).isEqualTo(4),
                () -> assertThat(StringCalculator.calculate("4 * 1")).isEqualTo(4),
                () -> assertThat(StringCalculator.calculate("0 * 8")).isEqualTo(0),
                () -> assertThat(StringCalculator.calculate("-2 * 22")).isEqualTo(-44),
                () -> assertThat(StringCalculator.calculate("-2 * 3 * 1 * 5")).isEqualTo(-30)
        );
    }

    @Test
    @DisplayName("사칙연산 테스트")
    void arithmetic() {
        assertAll(
                () -> assertThat(StringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10),
                () -> assertThat(StringCalculator.calculate("2 * 3 * 4 / 2")).isEqualTo(12),
                () -> assertThat(StringCalculator.calculate("4 / 2 * 4 / 2")).isEqualTo(4),
                () -> assertThat(StringCalculator.calculate("2 + 4 + 4 / 2")).isEqualTo(5),
                () -> assertThat(StringCalculator.calculate("2 - 3 * 4 / 2 * 3 + 1")).isEqualTo(-5)
        );
    }
}