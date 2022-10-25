import org.junit.jupiter.api.Test;
import calculator.StringCalculator;

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
    void 사칙연산이_아닌_연산() {
        assertThatThrownBy(() -> StringCalculator.calculate("10 % 3"));
    }

    @Test
    void 음수가_들어왔을때() {
        assertThatThrownBy(() -> StringCalculator.calculate("10 + -1"));
    }
}
