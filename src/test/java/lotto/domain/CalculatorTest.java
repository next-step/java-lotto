package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @Test
    void 덧셈() {
        assertThat(Calculator.run(1, 2, Operator.PLUS)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(Calculator.run(1, 2, Operator.MINUS)).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        assertThat(Calculator.run(2, 3, Operator.MULTIPLY)).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        assertThat(Calculator.run(4, 2,  Operator.DIVIDE)).isEqualTo(2);

        assertThatThrownBy(() ->
                Calculator.run(2, 3, Operator.DIVIDE)
        ).isInstanceOf(ArithmeticException.class);
    }
}
