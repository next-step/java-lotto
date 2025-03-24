package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @Test
    void 덧셈() {
        assertThat(Calculator.run(new Number(1), new Number(2), Operator.PLUS)).isEqualTo(new Number(3));
    }

    @Test
    void 뺄셈() {
        assertThat(Calculator.run(new Number(1), new Number(2), Operator.MINUS)).isEqualTo(new Number(-1));
    }

    @Test
    void 곱셈() {
        assertThat(Calculator.run(new Number(2), new Number(3), Operator.MULTIPLY)).isEqualTo(new Number(6));
    }

    @Test
    void 나눗셈() {
        assertThat(Calculator.run(new Number(4), new Number(2), Operator.DIVIDE)).isEqualTo(new Number(2));
    }

    @Test
    void 나눗셈_예외() {
        assertThatThrownBy(() ->
                Calculator.run(new Number(2), new Number(3), Operator.DIVIDE)
        ).isInstanceOf(ArithmeticException.class);
    }
}
