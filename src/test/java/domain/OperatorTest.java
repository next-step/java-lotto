package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @DisplayName("덧셈 연산 테스트")
    @Test
    void operateAddTest() {
        // Given
        Operand operand1 = new Operand(1);
        Operand operand2 = new Operand(2);

        // When
        Operator operator = new Operator("+");
        Integer result = operator.operate(operand1, operand2);

        // Then
        assertEquals(3, result);
    }

    @DisplayName("뺄셈 연산 테스트")
    @Test
    void operateSubtractTest() {
        // Given
        Operand operand1 = new Operand(1);
        Operand operand2 = new Operand(2);

        // When
        Operator operator = new Operator("-");
        Integer result = operator.operate(operand1, operand2);

        // Then
        assertEquals(-1, result);
    }
}