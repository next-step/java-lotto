package caculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class OperatorTest {

    @Test
    void 사칙연산_기호() {
        assertThat(Operator.of("/")).isEqualTo(Operator.DIVISION);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.of("%"))
                .withMessageMatching("사칙 연산 기호만 입력 가능합니다.");
    }

    @Test
    void 덧셈() {
        assertThat(Operator.ADDITION.calculate(1, 2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(Operator.SUBTRACTION.calculate(2, 1)).isEqualTo(1);
        assertThat(Operator.SUBTRACTION.calculate(1, 2)).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        assertThat(Operator.MULTIPLICATION.calculate(2, 3)).isEqualTo(6);
        assertThat(Operator.MULTIPLICATION.calculate(2, 0)).isEqualTo(0);
    }

    @Test
    void 나눗셈() {
        assertThat(Operator.DIVISION.calculate(4, 2)).isEqualTo(2);
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Operator.DIVISION.calculate(2, 0))
                .withMessageMatching("/ by zero");
    }
}
