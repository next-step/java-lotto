package stringcalculator.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ComplexCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 1;2", "3 + 3 / 2 - 3;0", "1 + 12 - 4 / 3;3", "1 + 12 - 4 / 3 * 0;0"}, delimiter = ';')
    @DisplayName("복잡한 계산하기")
    public void complexInput(final String input, final float result) {
        assertThat(ComplexCalculator.complexCalculate(input)).isEqualTo(result);
    }
}
