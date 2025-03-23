package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    @Test
    @DisplayName("덧셈")
    void plus() {
        Operand left = new Operand(10);
        Operand right = new Operand(20);

        StringCalculator stringCalculator = new StringCalculator();
        Operand result = stringCalculator.calculator(new Operator("+"), left, right);

        assertThat(result).isEqualTo(new Operand(30));
    }

}