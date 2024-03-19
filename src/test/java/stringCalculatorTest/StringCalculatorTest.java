package stringCalculatorTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import stringCalculator.StringCalculator;

public class StringCalculatorTest {
    @ParameterizedTest(name = "덧셈만 하는 {0} 의 결과값은 {1} 이다")
    @CsvSource(value = {"1 + 2=3", "2 + 3=5", "3 + 5=8", "5 + 8 + 1=14"}, delimiter = '=')
    void additionTest(String input, int expected) {
        int result = StringCalculator.calculation(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "뺄셈만 하는 {0} 의 결과값은 {1} 이다")
    @CsvSource(value = {"1 - 2=-1", "2 - 3=-1", "3 - 5=-2", "5 - 8 - 2=-5"}, delimiter = '=')
    void subtractTest(String input, int expected) {
        int result = StringCalculator.calculation(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "나눗셈만 하는 {0} 의 결과값은 {1} 이다")
    @CsvSource(value = {"2 / 1=2", "6 / 2=3", "1 / 1=1", "12 / 3 / 4=1"}, delimiter = '=')
    void divisionTest(String input, int expected) {
        int result = StringCalculator.calculation(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "곱셈만 하는 {0} 의 결과값은 {1} 이다")
    @CsvSource(value = {"2 * 1=2", "6 * 2=12", "1 * 1=1", "12 * 3 * 2=72"}, delimiter = '=')
    void multiplicationTest(String input, int expected) {
        int result = StringCalculator.calculation(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "곱셈만 하는 {0} 의 결과값은 {1} 이다")
    @CsvSource(value = {"2 + 3 * 4 / 2=10"}, delimiter = '=')
    void calculationTest(String input, int expected) {
        int result = StringCalculator.calculation(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0} 값을 입력시 IllegalArgumentException 발생")
    @NullAndEmptySource
    void inputBlankTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            StringCalculator.calculation(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0} 값을 입력시 사칙연산기호가 아니므로 IllegalArgumentException 발생")
    @ValueSource(strings = {"1 s 2", "2 % 3", "4 & 4"})
    void invaildOperationSymbolTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            StringCalculator.calculation(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
