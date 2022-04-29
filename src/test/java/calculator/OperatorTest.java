package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OperatorTest {

    @Test
    void plus_덧셈() {
        assertThat(Operator.PLUS.operate(new Operand(1), new Operand(2))).isEqualTo(new Operand(3));
    }

    @Test
    void minus_뺼셈() {
        assertThat(Operator.MINUS.operate(new Operand(2), new Operand(1))).isEqualTo(new Operand(1));
    }

    @Test
    void multiply_곱셈() {
        assertThat(Operator.MULTIPLY.operate(new Operand(2), new Operand(4))).isEqualTo(new Operand(8));
    }

    @Test
    void divide_나눗셈() {
        assertThat(Operator.DIVIDE.operate(new Operand(10), new Operand(2))).isEqualTo(new Operand(5));
    }

    @Test
    void divide_0으로_나눌수_없다() {
        assertThatThrownBy(() -> Operator.DIVIDE.operate(new Operand(10), new Operand(0))).isInstanceOf(ArithmeticException.class);
    }

    @Test
    void valueOfOperatorSymbol_사칙연산_기호가_아닌_경우() {
        assertThatThrownBy(() -> Operator.valueOfOperatorSymbol("%")).isInstanceOf(IllegalArgumentException.class);
    }
}
