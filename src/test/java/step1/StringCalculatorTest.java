package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "1 / 0:0"}, delimiter = ':')
    void calculate(String given, int expected) {
        StringCalculator cal = new StringCalculator();
        int actual = cal.calculate(given);

        assertThat(actual).isEqualTo(expected);
    }

}
