package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @DisplayName("문자열 분리 테스트")
    @Test
    void splitInputTest() {
        assertThat(calculator.splitInput("1 + 2 + 4 / 5 * 8 - 10")).containsExactly("1", "+", "2", "+", "4", "/", "5", "*", "8", "-", "10");
    }

    @DisplayName("덧셈테스트")
    @Test
    void sumTest() throws IllegalAccessException {
        assertThat(calculator.calculatorSystem("")).isEqualTo(0);
    }

    @DisplayName("뺄셈테스트")
    @Test
    void subtractionTest() throws IllegalAccessException {
        assertThat(calculator.calculatorSystem("")).isEqualTo(0);
    }

    @DisplayName("곱셈테스트")
    @Test
    void multiplicationTest() throws IllegalAccessException {
        assertThat(calculator.calculatorSystem("")).isEqualTo(0);
    }

    @DisplayName("나눗셈테스트")
    @Test
    void divisionTest() throws IllegalAccessException {
        assertThat(calculator.calculatorSystem("")).isEqualTo(0);
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

    @DisplayName("문자 테스트")
    @Test
    void stringTest() {
        assertThatExceptionOfType(IllegalAccessException.class).isThrownBy(() -> calculator.inputValueException(""));
    }

    @DisplayName("계산기 테스트")
    @Test
    void calculatorTest() throws IllegalAccessException {
        assertThat(calculator.calculatorSystem("")).isEqualTo(0);
    }
}
