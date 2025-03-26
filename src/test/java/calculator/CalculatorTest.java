package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    @DisplayName("계산기 - 덧셈 테스트")
    void plus() {
        Operand left = new Operand(10);
        Operand right = new Operand(20);

        Calculator calculator = new Calculator();
        Operand result = calculator.calculator(new Operator("+"), left, right);

        assertThat(result).isEqualTo(new Operand(30));
    }

}