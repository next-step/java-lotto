package step1.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperandTest {

    @Test
    @DisplayName("올바르지 않은 피연산자를 입력하면 예외 발생")
    void operandFailTest() {
        String token = "a";
        assertThatIllegalArgumentException().isThrownBy(() -> Operand.of(token));
    }

    @Test
    @DisplayName("PLUS 연산은 좌측의 피연산자와 우측의 피연산자를 더한다")
    void calculatePlusTest() {
        Operand left = Operand.of("2");
        Operand right = Operand.of("3");

        Operand resultPlus = Operator.PLUS.calculate(left, right);
        assertThat(resultPlus.getOperandValue()).isEqualTo(5);
    }

    @Test
    @DisplayName("MINUS 연산은 좌측의 피연산자와에서 우측의 피연산자를 뺀다.")
    void calculateMinusTest() {
        Operand left = Operand.of("5");
        Operand right = Operand.of("4");

        Operand resultPlus = Operator.MINUS.calculate(left, right);
        assertThat(resultPlus.getOperandValue()).isEqualTo(1);
    }


    @Test
    @DisplayName("MULTIPLE 연산은 좌측의 피연산자와 우측의 피연산자를 곱한다")
    void calculateMultipleTest() {
        Operand left = Operand.of("5");
        Operand right = Operand.of("2");

        Operand resultPlus = Operator.MULTIPLE.calculate(left, right);
        assertThat(resultPlus.getOperandValue()).isEqualTo(10);
    }

    @Test
    @DisplayName("0으로는 나눌수가 없다")
    void calculateDivideTest() {
        Operand left = Operand.of("2");
        Operand right = Operand.of("0");

        assertThatIllegalArgumentException().isThrownBy(
            () -> Operator.DIVIDE.calculate(left, right));
    }
}
