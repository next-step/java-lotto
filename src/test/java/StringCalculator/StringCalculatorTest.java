package StringCalculator;

import org.junit.jupiter.api.Test;

import static StringCalculator.StringCalculator.calculate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringCalculatorTest {
    @Test
    void 덧셈() {
        assertThat(calculate("2 + 3")).isEqualTo(5);
        //assertThat(plus(2,"+",3)).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        assertThat(calculate("2 - 3")).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        assertThat(calculate("2 * 3")).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        assertThat(calculate("2 / 3")).isEqualTo(0);
    }

    @Test
    void 입력값이null이거나_빈공백문자일경우_IllegalArgumentException() {
        assertAll(()-> {
            assertThatIllegalArgumentException().isThrownBy(() ->calculate("")),
        });
    }

    @Test
    void 사칙연산기호가아닌경우_IllegalArgumentException() {
    }

    @Test
    void 사칙연산을_모두포함() {
    }

}
