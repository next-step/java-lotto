package carculator.domain;

import carculator.domain.token.Operand;
import carculator.domain.token.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OperatorTest {


    @Test
    @DisplayName("숫자 두 개를 가지고 덧셈을 할 수 있다.")
    public void plusTest() {
        Operand num1 = new Operand(5);
        Operand num2 = new Operand(3);

        Integer output = Operator.PLUS.apply(num1, num2);
        assertThat(output).isEqualTo(8);
    }

    @Test
    @DisplayName("숫자 두 개를 가지고 뺄셈을 할 수 있다.")
    public void minusTest() {
        Operand num1 = new Operand(5);
        Operand num2 = new Operand(3);

        Integer output = Operator.MINUS.apply(num1, num2);
        assertThat(output).isEqualTo(2);
    }

    @Test
    @DisplayName("숫자 두 개를 가지고 곱셈을 할 수 있다.")
    public void multiplyTest() {
        Operand num1 = new Operand(5);
        Operand num2 = new Operand(3);

        Integer multiply = Operator.MULTIPLY.apply(num1, num2);
        assertThat(multiply).isEqualTo(15);
    }

    @Test
    @DisplayName("숫자 두 개를 가지고 나눗셈을 할 수 있다.")
    public void divideTest() {
        Operand num1 = new Operand(6);
        Operand num2 = new Operand(2);

        Integer output = Operator.DIVIDE.apply(num1, num2);
        assertThat(output).isEqualTo(3);
    }
}
