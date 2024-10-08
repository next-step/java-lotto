package calculator;

import static calculator.Calculator.convertStringToInt;
import static calculator.Calculator.validateString;
import static calculator.ErrorMessage.BLINK_INPUT_ERROR;
import static calculator.ErrorMessage.INPUT_IS_NOT_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.platform.commons.util.StringUtils.isBlank;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {
    @DisplayName("입력받은 문자가 빈 공백이거나 null일 경우 에러를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void 빈공백문자_혹은_null일경우_에러(String input) {
        assertThatThrownBy(() -> {
            validateString(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BLINK_INPUT_ERROR);
    }

    @DisplayName("입력받은 문자가 숫자일 경우 에러를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a"})
    void 숫자가_아닌경우_에러(String input) {
        assertThatThrownBy(() -> {
            convertStringToInt(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_IS_NOT_NUMBER);
    }
}