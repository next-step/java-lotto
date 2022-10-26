package StringCalculator.Calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ComplexCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 1;2", "3 + 3 / 2 - 3;0", "1 + 12 - 4 / 3;3", "1 + 12 - 4 / 3 * 0;0"}, delimiter = ';')
    public void complexInput(String input, float result) {
        assertThat(ComplexCalculator.complexCalculate(input)).isEqualTo(result);
    }
}
