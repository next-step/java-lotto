package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static util.ErrorMessage.INVALID_FORMAT;
import static util.ErrorMessage.INVALID_INPUT;

public class CalculatorTest {

    @Test
    @DisplayName("입력이 null 이면 IllegalArgumentException 발생시킨다.")
    void input_null_exception() {
        assertThatThrownBy(() -> Calculator.create().run(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("입력이 빈 문자열 이거나 공백만 있을 경우 IllegalArgumentException 발생시킨다.")
    void input_blank_exception(String input) {
        assertThatThrownBy(() -> Calculator.create().run(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_INPUT);
    }

    @Test
    @DisplayName("사칙연산 우선순위 없이 왼쪽부터 순차적으로 계산한다")
    void calculate_left() {
        Calculator calculator = Calculator.create();

        int result = calculator.run("2 + 3 * 4 / 2");

        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("왼쪽부터 순차적으로 계산한다.")
    void complex_left_2() {
        Calculator calculator = Calculator.create();

        int result = calculator.run("10 - 3 + 2 * 2 / 2");

        assertThat(result).isEqualTo(9);
    }

    @DisplayName("계산 수행 후 결과값을 반환한다.")
    @Test
    void return_value() {

        Calculator calculator = Calculator.create();
        assertThat(calculator.run("2 + 3 * 4")).isEqualTo(20);
    }

    @DisplayName("홀수가 아니면 exception을 반환한다")
    @Test
    void exception() {
        Calculator calculator = Calculator.create();
        assertThatThrownBy(() -> calculator.run("2 + "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_FORMAT);
    }
}
