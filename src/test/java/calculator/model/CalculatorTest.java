package calculator.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource(value = {"1 + 2, 3", "1 + 2 * 3, 9", "1 + 2 * 4 / 2, 6"})
    void calculate(String input, int expected) {
        Expression expression = new Expression(input);
        assertThat(calculator.calculate(expression.getNumbers(), expression.getOperator())).isEqualTo(expected);
    }
}
