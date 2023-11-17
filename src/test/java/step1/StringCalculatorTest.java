package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 - 3 * 4 / 5:0", "5 + 3 - 2 / 3 * 5:10"}, delimiter = ':')
    public void calculate(String input, int expected) {
        StringCalculator calculator = new StringCalculator(Tokenizer.tokens(input));
        Assertions.assertThat(calculator.calculate()).isEqualTo(expected);
    }
}
