package step1.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {

    @Test
    void 연산자는_정해진_기호를_가진다() {
        Operator operator = Operator.PLUS;
        assertThat(operator.getSymbol()).isEqualTo('+');
    }

    @Test
    void PLUS_연산자는_피연산자_2개로_더하기_연산을_한다() {
        Operator plus = Operator.PLUS;
        Operand operand1 = new Operand(1);
        Operand operand2 = new Operand(1);

        assertThat(plus.apply(operand1, operand2)).isEqualTo(new Operand(2));
    }
    @Test
    void MINUS_연산자는_피연산자_2개로_빼기_연산을_한다() {
        Operator minus = Operator.MINUS;
        Operand operand1 = new Operand(1);
        Operand operand2 = new Operand(1);

        assertThat(minus.apply(operand1, operand2)).isEqualTo(new Operand(0));
    }
    @Test
    void MULTIPLY_연산자는_피연산자_2개로_곱하기_연산을_한다() {
        Operator multiply = Operator.MULTIPLY;
        Operand operand1 = new Operand(2);
        Operand operand2 = new Operand(3);

        assertThat(multiply.apply(operand1, operand2)).isEqualTo(new Operand(6));
    }
    @Test
    void DIVIDE_연산자는_피연산자_2개로_나누기_연산을_한다() {
        Operator divide = Operator.DIVIDE;
        Operand operand1 = new Operand(6);
        Operand operand2 = new Operand(2);

        assertThat(divide.apply(operand1, operand2)).isEqualTo(new Operand(3));
    }

    @Test
    void 나눗셈_결과가_정수로_떨어지지_않는다면_에러() {
        Operator divide = Operator.DIVIDE;
        Operand operand1 = new Operand(4);
        Operand operand2 = new Operand(3);

        assertThatThrownBy(() -> divide.apply(operand1, operand2))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 나눗셈_우항이_0이면_에러() {
        Operator divide = Operator.DIVIDE;
        Operand operand1 = new Operand(4);
        Operand operand2 = new Operand(0);

        assertThatThrownBy(() -> divide.apply(operand1, operand2))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 잘못된_연산자는_에러() {
        assertThatThrownBy(() -> Operator.fromSymbol('!'))
                .isInstanceOf(RuntimeException.class);
    }
}
