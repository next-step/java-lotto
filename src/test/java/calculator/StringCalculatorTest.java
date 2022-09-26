package calculator;

import calculator.model.Operand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/testcase.csv")
    void shouldCalculate(String input, String expectedResult) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(new Operand(expectedResult));
    }

    @Test
    void shouldThrowException_whenInvalidInput() {
        assertThatThrownBy(() -> StringCalculator.calculate("1 1 1 * 3 + 4")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> StringCalculator.calculate("+ 1 + 1 * 3 + 4")).isInstanceOf(IllegalArgumentException.class);
    }
}
