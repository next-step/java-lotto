import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = { "1 + 2,3", "2 - 1,1", "3 * 2,6", "4 / 2,2" }, delimiter = ',')
    void calculate(String input, int expected) {
        final StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.calculateString(input)).isEqualTo(expected);
    }
}
