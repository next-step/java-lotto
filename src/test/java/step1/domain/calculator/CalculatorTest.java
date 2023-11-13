package step1.domain.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    private static final String SPLIT_SEPARATOR = "\\s";

    Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource(value = {"'5 + 6', 11", "'5 + 3', 8", "'5 + 2', 7"})
    void 덧셈_테스트(String input, int expected) {
        int result = calculator.calculate(input.trim().split(SPLIT_SEPARATOR));
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"'5 - 6', -1", "'5 - 5', 0", "'5 - 2', 3"})
    void 뺄셈_테스트(String input, int expected) {
        int result = calculator.calculate(input.trim().split(SPLIT_SEPARATOR));
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"'5 * 6', 30", "'5 * 5', 25", "'5 * 2', 10"})
    void 곱셈_테스트(String input, int expected) {
        int result = calculator.calculate(input.trim().split(SPLIT_SEPARATOR));
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"'30 / 2', 15", "'30 / 6', 5", "'30 / 3', 10"})
    void 나눗셈_테스트(String input, int expected) {
        int result = calculator.calculate(input.trim().split(SPLIT_SEPARATOR));
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"'30 / 31'", "'30 / 7'", "'30 / 9'", "'30 / 0'"})
    void 나눗셈_테스트_오류(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input.trim().split(SPLIT_SEPARATOR)));
    }

    @ParameterizedTest
    @CsvSource(value = {"'2 + 3 * 4 / 2', 10", "'5 * 4 / 2 - 10 + 4 - 2 * 3', 6"})
    void 긴_수식_계산_테스트(String input, int expected) {
        int result = calculator.calculate(input.trim().split(SPLIT_SEPARATOR));
        assertThat(result).isEqualTo(expected);
    }
}