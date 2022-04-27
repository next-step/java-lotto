package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @Test
    void 입력값이_널이거나_비어있는_경우_예외_발생() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    String input = "";
                    new Calculator(input);
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    String input = null;
                    new Calculator(input);
                });
    }

    @Test
    void 덧셈() { assertThat(Operation.PLUS.calculate(1, 3)).isEqualTo(4); }

    @Test
    void 뺄셈() {
        assertThat(Operation.MINUS.calculate(2, 2)).isEqualTo(0);
    }

    @Test
    void 곱셈() {
        assertThat(Operation.MULTIPLY.calculate(2, 2)).isEqualTo(4);
    }

    @Test
    void 나눗셈() {
        assertThat(Operation.DIVIDE.calculate(4, 2)).isEqualTo(2);
    }

    @Test
    void 숫자와_연산자를_구별한다() {
        Calculator operation = new Calculator("2 + 3 * 4 / 2");
        assertThat(operation.operation()).isEqualTo(10);
    }
}