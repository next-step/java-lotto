package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @Test
    void 덧셈() {
        Calculator calculator = new Calculator();
        assertThat(calculator.add(1, 2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        Calculator calculator = new Calculator();
        assertThat(calculator.subtract(1, 2)).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        Calculator calculator = new Calculator();
        assertThat(calculator.multiply(2, 3)).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        Calculator calculator = new Calculator();
        assertThat(calculator.divide(4, 2)).isEqualTo(2);

        assertThatThrownBy(() ->
                calculator.divide(2, 3)
        ).isInstanceOf(ArithmeticException.class);
    }
}
