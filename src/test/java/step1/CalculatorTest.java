package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
}
