import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @Test
    void calculateWithNullOrEmpty() {
        assertThat(StringCalculator.calculate("")).isEqualTo(0);
        assertThat(StringCalculator.calculate(null)).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "1"})
    void calculateOnlyOne(String text) {
        assertThat(StringCalculator.calculate(text)).isEqualTo(Integer.parseInt(text));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1=2", "3,1=4"}, delimiter = '=')
    void calculateWithComma(String text, int expect) {
        assertThat(StringCalculator.calculate(text)).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1=2", "3:1=4"}, delimiter = '=')
    void calculateWithColon(String text, int expect) {
        assertThat(StringCalculator.calculate(text)).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1,3=5", "3,1:4=8"}, delimiter = '=')
    void calculateWithCommaAndColon(String text, int expect) {
        assertThat(StringCalculator.calculate(text)).isEqualTo(expect);
    }
}