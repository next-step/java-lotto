package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2, 3", "1 + 2 * 3, 9", "1 + 2 * 3 / 4, 2"})
    void 사칙연산_모두_포함(String input, int expected) {
        Expression expression = new Expression(input);
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate(expression.getNumbers(), expression.getOperators())).isEqualTo(expected);
    }
}

