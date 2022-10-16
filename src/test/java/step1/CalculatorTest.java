package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    @DisplayName("입력 문자열을 빈 공백 문자로 분리")
    @Test
    void splitTest() {
        String input = "1 + 2 / 1";

        String[] result = Calculator.split(input);

        assertThat(result).containsExactly("1", "+", "2", "/", "1");
    }

    @DisplayName("피연산자 정수로 변환")
    @Test
    void operandToIntTest() {
        String operand = "3";

        int result = Calculator.toInt(operand);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("피연산자 정수로 변환 중 예외 발생")
    @Test
    void operandToIntExceptionTest() {
        assertThatThrownBy(() -> Calculator.toInt("*1")).isExactlyInstanceOf(NumberFormatException.class);
    }

    @DisplayName("유효하지 않은 피연산자로 계산할 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1* + 2", "1 + 2*", " + 2"})
    void calculateNotNumberOperandsTest(String input) {
        assertThatThrownBy(() -> Calculator.calculate(input))
            .isExactlyInstanceOf(NumberFormatException.class);
    }

    @DisplayName("유효하지 않은 연산자로 계산할 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1 2", "1  2", "1 & 2", "1 ? 2", "1 3 2"})
    void calculateNotOperatorTest(String input) {
        assertThatThrownBy(() -> Calculator.calculate(input))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효하지 않은 계산식일 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1 + ", "1 +  ", "  + 2"})
    void calculateInvalidExpressionTest(String input) {
        assertThatThrownBy(() -> Calculator.calculate(input))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("덧셈 계산")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "2 + 3:5", "1 + 2 + 3:6"}, delimiter = ':')
    void calculatePlus(String input, int expected) {
        int result = Calculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("뺄셈 계산")
    @ParameterizedTest
    @CsvSource(value = {"1 - 2:-1", "3 - 2:1", "1 - 2 - 3:-4"}, delimiter = ':')
    void calculateMinus(String input, int expected) {
        int result = Calculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("곱셈 계산")
    @ParameterizedTest
    @CsvSource(value = {"2 * 3:6", "2 * -1:-2", "-3 * -3:9"}, delimiter = ':')
    void calculateMultiplication(String input, int expected) {
        int result = Calculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("나눗셈 계산")
    @ParameterizedTest
    @CsvSource(value = {"1 / 2:0", "2 / 2:1", "3 / 2:1", "-2 / 2:-1", "2 / -2:-1"}, delimiter = ':')
    void calculateDivision(String input, int expected) {
        int result = Calculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("0으로 나누는 경우 예외 발생")
    @Test
    void calculateDivideWithZero() {
        assertThatThrownBy(() -> Calculator.calculate("2 / 0"))
            .isExactlyInstanceOf(ArithmeticException.class);
    }

    @DisplayName("연산자가 2개 이상인 계산")
    @ParameterizedTest
    @CsvSource(value = {"1 - 2 * 3:-3", "3 / 3 + 1:2", "2 * 3 - 3:3", "2 * 4 / 3 + 2 - 1:3"}, delimiter = ':')
    void calculateComposite(String input, int expected) {
        int result = Calculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }
}
