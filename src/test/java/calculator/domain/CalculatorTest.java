package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {"4 + 3 / 2:3", "5 * 6 / 2:15", "18 / 4 * 2 - 7:1"}, delimiter = ':')
    @DisplayName("연산 테스트")
    public void calculateTest(String input, int result) {
        Calculator calculator = new Calculator(input);

        calculator.calculateWholeFormula();

        assertThat(calculator.getCurrentResult()).isEqualTo(result);
    }

}