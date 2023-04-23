package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void when_expressionContainsEveryArithmeticExpression() {
        String expression = "1 + 3 / 2 * 10 - 2 + 1 + -9";
        Calculator calculator = new Calculator(expression);
        int result = calculator.calculate();

        assertThat(result).isEqualTo(10);
    }
}
