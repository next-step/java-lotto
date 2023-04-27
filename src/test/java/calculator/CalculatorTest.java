package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    @ParameterizedTest
    @CsvSource({
            "2 + 3 + 4, 9",
            "10 - 13 - 100, -103",
            "2 * 3 * 4, 24",
            "12 / 2 / 3, 2",
            "2 + 3 * 4 / 2, 10"
    })
    public void performArithmetics(String input, Integer evaluation) {
        Expression expression = Expression.fromString(input);
        Calculator calculator = new Calculator();

        var result = calculator.evaluate(expression);

        assertThat(result).isEqualTo(evaluation);
    }
}
