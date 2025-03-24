import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @Test
    @DisplayName("표현식을 계산한다.")
    void calculate() {
        Expression expression = Expression.createExpression("2 + 3 * 4 / 2");
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate(expression)).isEqualTo(10);
    }
}