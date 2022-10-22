package caculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class ExpressionTypeTest {

    @Test
    void 사칙연산_기호() {
        assertThat(ExpressionType.isSign("/")).isTrue();
        assertThat(ExpressionType.isSign("%")).isFalse();
    }

    @Test
    void 덧셈() {
        assertThat(ExpressionType.ADDITION.calculate(1, 2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(ExpressionType.SUBTRACTION.calculate(2, 1)).isEqualTo(1);
        assertThat(ExpressionType.SUBTRACTION.calculate(1, 2)).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        assertThat(ExpressionType.MULTIPLICATION.calculate(2, 3)).isEqualTo(6);
        assertThat(ExpressionType.MULTIPLICATION.calculate(2, 0)).isEqualTo(0);
    }

    @Test
    void 나눗셈() {
        assertThat(ExpressionType.DIVISION.calculate(4, 2)).isEqualTo(2);
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> ExpressionType.DIVISION.calculate(2, 0))
                .withMessageMatching("/ by zero");
    }
}