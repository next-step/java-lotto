import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @ParameterizedTest
    @DisplayName("더하기가 정상적으로 동작하는지 확인")
    @CsvSource(value = {"1 + 2:3", "3 + 2 + 1 :6", "0 + 1:1"}, delimiter = ':')
    public void validate_plus(String input, int answer) {
        int result = Calculator.calc(input);
        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @DisplayName("빼기가 정상적으로 동작하는지 확인")
    @CsvSource(value = {"1 - 2:-1", "3 - 2 - 1 :0", "0 - -1:1"}, delimiter = ':')
    public void validate_minus(String input, int answer) {
        int result = Calculator.calc(input);
        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @DisplayName("나누기가 정상적으로 동작하는지 확인")
    @CsvSource(value = {"2 / 2: 1", "4 / 2 :2"}, delimiter = ':')
    public void validate_dive(String input, int answer) {
        int result = Calculator.calc(input);
        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @DisplayName("곱셈이 정상적으로 동작하는지 확인")
    @CsvSource(value = {"2 * 2: 4", "3 * 2 * 1 :6", "0 * -1:0"}, delimiter = ':')
    public void validate_multiply(String input, int answer) {
        int result = Calculator.calc(input);
        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @DisplayName("사칙연산이 정상적으로 동작하는지 확인")
    @CsvSource(value = {"2 * 2 - 2: 2", "4 - 2 * 1 :2", "-1 * -1 - 1:0"}, delimiter = ':')
    public void validate_calc(String input, int answer) {
        int result = Calculator.calc(input);
        assertThat(result).isEqualTo(answer);
    }
}
