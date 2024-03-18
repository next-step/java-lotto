package stringCalculatorTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {"1 + 2=3", "2 + 3=5", "3 + 5=8", "5 + 8=13"}, delimiter = '=')
    void additionTest(String input, int expected) {
        int result = StringCalculator.addition(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
