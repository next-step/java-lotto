package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @DisplayName("문자열 분리 테스트")
    @Test
    void splitInputTest() throws IllegalAccessException {
        assertThat(calculator.splitInput("1 + 2 + 4 / 5 * 8 - 10")).containsExactly("1", "+", "2", "+", "4", "/", "5", "*", "8", "-", "10");
    }

    @DisplayName("덧셈테스트")
    @Test
    void sumTest() {
        assertThat(calculator.sum(1, 2)).isEqualTo(3);
    }

    @DisplayName("뺄셈테스트")
    @Test
    void subtractionTest() {
        assertThat(calculator.subtraction(1, 8)).isEqualTo(-7);
    }

    @DisplayName("곱셈테스트")
    @Test
    void multiplicationTest() {
        assertThat(calculator.multiplication(4, 2)).isEqualTo(8);
    }

    @DisplayName("나눗셈테스트")
    @Test
    void divisionTest() {
        assertThat(calculator.division(3, 2)).isEqualTo(1);
    }

    @DisplayName("null값 테스트")
    @Test
    void nullTest() {
        assertThatExceptionOfType(IllegalAccessException.class).isThrownBy(() -> calculator.inputValueException(null));
    }

    @DisplayName("빈값 테스트")
    @Test
    void emptyTest() {
        assertThatExceptionOfType(IllegalAccessException.class).isThrownBy(() -> calculator.inputValueException(""));
    }

    @DisplayName("사칙연산자 이외 문자 테스트")
    @Test
    void stringTest() {
        assertThatExceptionOfType(IllegalAccessException.class).isThrownBy(() -> calculator.operatorException("1 ."));
    }

    @DisplayName("수식 비정상종료 테스트")
    @Test
    void equationExceptionTest() {
        assertThatExceptionOfType(IllegalAccessException.class).isThrownBy(() -> calculator.finalCalculate("1 +"));
    }

    @DisplayName("계산기 테스트")
    @Test
    void calculatorTest() throws IllegalAccessException {
        assertThat(calculator.finalCalculate("1 + 2 / 4 + 9 * 4 - 1")).isEqualTo(35);
    }
}
