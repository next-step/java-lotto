package stringCalculatorTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {
    @ParameterizedTest(name = "덧셈만 하는 {0} 의 결과값은 {1} 이다")
    @CsvSource(value = {"1 + 2=3", "2 + 3=5", "3 + 5=8", "5 + 8=13"}, delimiter = '=')
    void additionTest(String input, int expected) {
        int result = StringCalculator.addition(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "뺄셈만 하는 {0} 의 결과값은 {1} 이다")
    @CsvSource(value = {"1 - 2=-1", "2 - 3=-1", "3 - 5=-2", "5 - 8=-3"}, delimiter = '=')
    void subtractTest(String input, int expected) {
        int result = StringCalculator.subtract(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
