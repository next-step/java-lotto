package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step1.domain.Calculator;
import step1.domain.Expression;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    @Test
    void add() {
        Expression expression = new Expression("1 + 2");
        int result = calculator.calculate(expression);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void minus() {
        Expression expression = new Expression("3 - 2");
        int result = calculator.calculate(expression);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void multiple() {
        Expression expression = new Expression("3 * 2");
        int result = calculator.calculate(expression);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void divide() {
        Expression expression = new Expression("3 / 2");
        int result = calculator.calculate(expression);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void All() {
        Expression expression = new Expression("2 + 3 * 4 / 2");
        int result = calculator.calculate(expression);
        assertThat(result).isEqualTo(10);
    }
}
