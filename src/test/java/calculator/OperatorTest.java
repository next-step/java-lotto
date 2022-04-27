package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OperatorTest {

    @Test
    void plus_덧셈() {
        assertThat(Operator.PLUS.operate(1, 2)).isEqualTo(3);
    }

    @Test
    void minus_뺼셈() {
        assertThat(Operator.MINUS.operate(2, 1)).isEqualTo(1);
    }

    @Test
    void multiply_곱셈() {
        assertThat(Operator.MULTIPLY.operate(2, 4)).isEqualTo(8);
    }

    @Test
    void divide_나눗셈() {
        assertThat(Operator.DIVIDE.operate(10, 2)).isEqualTo(5);
    }

    @Test
    void divide_0으로_나눌수_없다() {
        assertThatThrownBy(() -> Operator.DIVIDE.operate(10, 0)).isInstanceOf(ArithmeticException.class);
    }
}
