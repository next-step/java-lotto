package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OperatorTest {

    @Test
    @DisplayName("사칙연산 계산 테스트 성공")
    void operatorTest() {
        int operand1 = 5;
        int operand2 = 2;

        int addResult = Operator.PLUS.calculate(operand1, operand2);
        assertThat(addResult).isEqualTo(7);

        int subtractResult = Operator.MINUS.calculate(operand1, operand2);
        assertThat(subtractResult).isEqualTo(3);

        int multiplyResult = Operator.MULTIPLY.calculate(operand1, operand2);
        assertThat(multiplyResult).isEqualTo(10);

        int divideResult = Operator.DIVIDE.calculate(operand1, operand2);
        assertThat(divideResult).isEqualTo(2);
    }

    @Test
    @DisplayName("")
    void findOperatorFailByWrongOperator() {
        String symbol = "&";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.findOperator(symbol));
    }
}
