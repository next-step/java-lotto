package stringCalculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {
    @Test
    void test_add() {
        assertThat(StringCalculator.calculate("1 + 2 + 5")).isEqualTo(8);
    }

    @Test
    void test_subtract() {
        assertThat(StringCalculator.calculate("1 - 2 - 2")).isEqualTo(-3);
    }

    @Test
    void test_multiply() {
        assertThat(StringCalculator.calculate("1 * 2 * 3")).isEqualTo(6);
    }

    @Test
    void test_divide() {
        assertThat(StringCalculator.calculate("15 / 5 / 3")).isEqualTo(1);
    }

    @Test
    void test_mixedOp() {
        assertThat(StringCalculator.calculate("15 / 5 * 2 + 4 - 1")).isEqualTo(9);
    }

    @Test
    void exceptionTest_정수가아닌나눗셈() {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate("7 / 8 / 9"));
    }
}