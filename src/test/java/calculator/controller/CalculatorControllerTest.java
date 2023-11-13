package calculator.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorControllerTest {

    @Test
    @DisplayName("연산식이 null이거나 빈 공백 문자일 경우 IllegalArgumentException를 반환한다. ")
    void validate_null() {
        assertThatThrownBy(() -> new CalculatorController(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 형식에 맞지 않습니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "2+ 3 * 4 / 2"
            , "2+ 3 * 4 /"
            , "2  +3 * 4 / 2"
            , "+ 3 / 2"})
    @DisplayName("연산식의 형식이 맞지 않을 경우 IllegalArgumentException를 반환한다.")
    void validate_pattern(String expression) {
        assertThatThrownBy(() -> new CalculatorController(expression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 형식에 맞지 않습니다");

    }
}
