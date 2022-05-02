package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈식을 입력하면 더한 결과가 반환된다.")
    void add() {
        int result = Calculator.calculate("2 + 3");
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈식을 입력하면 뺀 결과가 반환된다.")
    void subtract() {
        int result = Calculator.calculate("4 - 2");
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈식을 입력하면 곱한 결과가 반환된다.")
    void multiply() {
        int result = Calculator.calculate("8 * 2");
        Assertions.assertThat(result).isEqualTo(16);
    }

    @Test
    @DisplayName("나눗셈식을 입력하면 나눈 결과가 반환된다.")
    void divide() {
        int result = Calculator.calculate("8 / 2");
        Assertions.assertThat(result).isEqualTo(4);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "3 * 2 - 2 / 2:2", "10 - 1 / 3 + 4:7"}, delimiter = ':')
    @DisplayName("입력값에 따라 계산 순서가 결정된다.")
    void calculate(String input, int expected) {
        int result = Calculator.calculate(input);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "   ", ""})
    @DisplayName("입력값이 공백 문자인 경우 예외를 반환한다.")
    void input_empty(String input) {
        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input cannot be null or empty.");
    }

    @Test
    @DisplayName("입력값이 null인 경우 예외를 반환한다.")
    void input_null() {
        assertThatThrownBy(() -> Calculator.calculate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input cannot be null or empty.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 , 3", "1 = 2", "4 . 3 ; 9"})
    @DisplayName("입력값 중에 사칙연산 기호가 아닌 문자가 포함될 경우 예외를 반환한다.")
    void input_illegal(String input) {
        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input cannot be parsed.");
    }
}
