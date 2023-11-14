package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @DisplayName("입력값이 null 혹은 빈공백 문자열이 아닌지 확인한다.")
    @Test
    void validateInput() {
        assertThatThrownBy(() -> new Calculator(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("null");

        String input = "";
        assertThatThrownBy(() -> new Calculator(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("empty");
    }

    @DisplayName("입력한 문자를 공백으로 분리한다.")
    @Test
    void splitInput() {
        // given
        String input = "1 + 2 * 3 - 4";

        // when
        Calculator calculator = new Calculator(input);

        // then
        assertThat(calculator.operands())
            .hasSize(4)
            .contains(1);
        assertThat(calculator.operators())
            .hasSize(3)
            .contains("+");
    }

    @DisplayName("사칙연산 기호가 아닌값이 있는지 확인한다.")
    @Test
    void validateOperator() {
        // given
        String input = "1 & 2";

        // when, then
        assertThatThrownBy(() -> new Calculator(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("덧셈 기능을 구현한다.")
    @Test
    void sumTest() {
        // given
        String input = "1 + 2";
        Calculator calculator = new Calculator(input);

        // when, then
        assertThat(calculator.sum(1,2)).isEqualTo(3);
    }


    @DisplayName("뺄셈 기능을 구현한다.")
    @Test
    void substractionTest() {
        // given
        String input = "2 - 1";
        Calculator calculator = new Calculator(input);

        // when, then
        assertThat(calculator.subtraction(2,1)).isEqualTo(1);
    }


    @DisplayName("곱셈 기능을 구현한다.")
    @Test
    void multiplicationTest() {
        // given
        String input = "2 * 5";
        Calculator calculator = new Calculator(input);

        // when, then
        assertThat(calculator.multiplication(2,5)).isEqualTo(10);
    }

    @DisplayName("나눗셈 기능을 구현한다.")
    @Test
    void divisionTest() {
        // given
        String input = "4 / 2";
        Calculator calculator = new Calculator(input);

        // when, then
        assertThat(calculator.division(4,2)).isEqualTo(2);
    }
}


