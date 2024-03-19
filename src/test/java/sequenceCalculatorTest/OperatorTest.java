package sequenceCalculatorTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sequenceCalculator.Operator;

public class OperatorTest {

    @Test
    @DisplayName("문자열 +를 만나면 Operator.PLUS 반환")
    void MEET_PLUS_OPERATION_THEN_OPERATOR_PLUS_RETURN() {
        assertThat(Operator.findOperator("+")).isEqualTo(Operator.PLUS);
    }

    @Test
    @DisplayName("문자열 -를 만나면 Operator.MINUS 반환")
    void MEET_MINUS_OPERATION_THEN_OPERATOR_MINUS_RETURN() {
        assertThat(Operator.findOperator("-")).isEqualTo(Operator.MINUS);
    }

    @Test
    @DisplayName("문자열 /를 만나면 Operator.DIVIDE 반환")
    void MEET_DIVIDE_OPERATION_THEN_OPERATOR_DIVIDE_RETURN() {
        assertThat(Operator.findOperator("/")).isEqualTo(Operator.DIVIDE);
    }

    @Test
    @DisplayName("문자열 *를 만나면 Operator.MULTIPLY 반환")
    void MEET_MULTIPLY_OPERATION_THEN_OPERATOR_MULTIPLY_RETURN() {
        assertThat(Operator.findOperator("*")).isEqualTo(Operator.MULTIPLY);
    }

    @Test
    @DisplayName("각각의 OPERATOR 사칙연산 테스트")
    void BASIC_OPERATION_TEST_BY_EACH_OPERATOR() {
        assertThat(Operator.PLUS.calculate(4,2)).isEqualTo(6);
        assertThat(Operator.MINUS.calculate(4,2)).isEqualTo(2);
        assertThat(Operator.DIVIDE.calculate(4,2)).isEqualTo(2);
        assertThat(Operator.MULTIPLY.calculate(4,2)).isEqualTo(8);
    }

}
