package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3:6"}, delimiter = ':')
    void calculate(String expression, int expected) {
        StringCalculator stringCalculator = new StringCalculatorTest(expression);

        int actual = stringCalculator.calculate();

        assertThat(result).isEqualTo(expected);
    }
}
