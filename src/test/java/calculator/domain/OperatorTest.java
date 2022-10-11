package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OperatorTest {
    private final int num1 = 1;
    private final int num2 = 2;

    @Test
    void 덧셈_연산을_확인한다() {
        double number = Operator.execute("+", num1, num2);

        assertThat(number).isEqualTo(3);
    }

    @Test
    void 뺄셈_연산을_확인한다() {
        double number = Operator.execute("-", num1, num2);

        assertThat(number).isEqualTo(-1);
    }

    @Test
    void 곱셈_연산을_확인한다() {
        double number = Operator.execute("*", num1, num2);

        assertThat(number).isEqualTo(2);
    }

    @Test
    void 나눗셈_연산을_확인한다() {
        double number = Operator.execute("/", num1, num2);

        assertThat(number).isEqualTo(0.5);
    }

    @Test
    void 사칙연산_기호가_아닐_경우을_확인한다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Operator.execute("&", num1, num2));
    }
}
