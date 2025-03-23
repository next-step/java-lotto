import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperatorTest {
    @Test
    @DisplayName("덧셈 연산을 한다.")
    public void plusCalculate() {
        assertEquals(Operator.PLUS.calculate(2, 3), 5);
    }

    @Test
    @DisplayName("뺄셈 연산을 한다.")
    public void minusCalculate() {
        assertEquals(Operator.MINUS.calculate(3, 2), 1);
    }

    @Test
    @DisplayName("곱셈 연산을 한다.")
    public void multiplyCalculate() {
        assertEquals(Operator.MULTIPLY.calculate(2, 3), 6);
    }

    @Test
    @DisplayName("나눗셈 연산을 한다.")
    public void divisionCalculate() {
        assertEquals(Operator.DIVISION.calculate(6, 3), 2);
    }
}