package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2, 3", "1 + 2 * 3, 9", "1 + 2 * 4 / 2, 6"})
    void calculate(String input, int expected) {
        Expression expression = new Expression(input);
        Calculator calculator = new Calculator();

        assertThat(calculator.calculate(expression.getNumbers(), expression.getOperator())).isEqualTo(expected);
    }
}