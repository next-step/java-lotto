package calculator;

import static calculator.Calculator.INPUT_OPERATOR_EXCEPTION;
import static calculator.Calculator.INPUT_TEXT_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈을 할 수 있다.")
    void plus() {
        // given
        Calculator calculator = new Calculator();
        String given = "1 + 3";

        // when
        long result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("뺼셈을 할 수 있다.")
    void minus() {
        // given
        Calculator calculator = new Calculator();
        String given = "2 - 4";

        // when
        long result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(-2);
    }

    @Test
    @DisplayName("곱셈을 할 수 있다.")
    void multiply() {
        // given
        Calculator calculator = new Calculator();
        String given = "3 * 5";

        // when
        long result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(15);
    }

    @Test
    @DisplayName("나눗셈을 할 수 있다.")
    void divide() {
        // given
        Calculator calculator = new Calculator();
        String given = "15 / 3";

        // when
        long result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 예외를 던진다.")
    @NullAndEmptySource
    void input_text_exception(String given) {
        // given
        Calculator calculator = new Calculator();

        // when // then
        assertThatThrownBy(() -> calculator.calculate(given))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_TEXT_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("사칙연산 기호가 아닌 경우 예외를 던진다.")
    @ValueSource(strings = {"3 ^ 4", "8 # 7"})
    void input_operator_exception(String given) {
        // given
        Calculator calculator = new Calculator();

        // when // then
        assertThatThrownBy(() -> calculator.calculate(given))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_OPERATOR_EXCEPTION);
    }
}
