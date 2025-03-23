package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {

    @Test
    void 연산자는_정해진_기호를_가진다() {
        Operator operator = Operator.PLUS;
        assertThat(operator.symbol()).isEqualTo('+');
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
        Operator plus = Operator.MINUS;
        Operand operand1 = new Operand(1);
        Operand operand2 = new Operand(1);

        assertThat(plus.apply(operand1, operand2)).isEqualTo(new Operand(0));
    }
    @Test
    void MULTIPLY_연산자는_피연산자_2개로_곱하기_연산을_한다() {
        Operator plus = Operator.MULTIPLY;
        Operand operand1 = new Operand(2);
        Operand operand2 = new Operand(3);

        assertThat(plus.apply(operand1, operand2)).isEqualTo(new Operand(6));
    }
    @Test
    void DIVIDE_연산자는_피연산자_2개로_나누기_연산을_한다() {
        Operator plus = Operator.DIVIDE;
        Operand operand1 = new Operand(6);
        Operand operand2 = new Operand(2);

        assertThat(plus.apply(operand1, operand2)).isEqualTo(new Operand(3));
    }
}
