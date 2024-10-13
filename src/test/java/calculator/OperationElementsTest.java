package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class OperationElementsTest {
    @Test
    void 피연산자_개수가_2개_미만이면_예외_발생() {
        // given
        List<OperationType> operators = List.of(OperationType.ADD, OperationType.DIVIDE);
        List<Integer> operands = List.of(1);
        OperationElements operationElements = new OperationElements(operators, operands);

        // when, then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(operationElements::operate)
                .withMessage("피연산자는 최소 2개는 입력되어야 합니다");
    }

    @Test
    void 연산자가_없으면_예외_발생() {
        // given
        List<OperationType> operators = List.of();
        List<Integer> operands = List.of(1, 2);
        OperationElements operationElements = new OperationElements(operators, operands);

        // when, then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(operationElements::operate)
                .withMessage("연산자는 최소 1개는 입력되어야 합니다");
    }
}
