package calculator.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CalculatorControllerTest {

    @Test
    @DisplayName("연산식이 null이거나 빈 공백 문자일 경우 IllegalArgumentException를 반환한다. ")
    void validate_null() {
        assertThatThrownBy(() -> new CalculatorController(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산식이 입력되지 않았습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "2+ 3 * 4 / 2"
            , "2+ 3 * 4 /"
            , "2  +3 * 4 / 2"
            , "+ 3 / 2"})
    @DisplayName("연산식의 형식이 맞지 않을 경우 IllegalArgumentException를 반환한다.")
    void validate_invalid_pattern(String expression) {
        assertThatThrownBy(() -> new CalculatorController(expression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 형식에 맞지 않습니다");

    }

    @ParameterizedTest
    @ValueSource(strings = {
            "2 + 3 * 4 / 2"
            , "2 + 3"
            , "4 / 2"})
    @DisplayName("연산식의 형식이 맞을 경우 예외를 반환하지 않는다.")
    void validate_valid_pattern(String expression) {
        assertThatCode(() -> new CalculatorController(expression))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource(value = {"'2 * 3 / 2':3", "'5 + 3 - 3':5", "'5 * 3 - 2 / 2':6"}, delimiter = ':')
    @DisplayName("입력값의 순서에 따라 계산이 제대로 되는지 확인한다.")
    void calculate(String expression, int expected) {
        CalculatorController controller = new CalculatorController(expression);

        int actual = controller.calculate(expression);

        assertThat(actual).isEqualTo(expected);
    }
}
