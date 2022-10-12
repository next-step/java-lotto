package stringcalculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 / 2:2", "2 + 3 * 4 / 2:10", "2 - 4:-2"}, delimiter = ':')
    @DisplayName("계산한다")
    void calculate(String input, String expected) {
        StringCalculator calculator = new StringCalculator(new InputValue(input));
        int result = calculator.calculate();
        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }

}
