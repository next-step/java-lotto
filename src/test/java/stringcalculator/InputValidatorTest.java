package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();
    @Test
    @DisplayName("입력 값의 토큰이 사칙 연산 기호가 아닌 경우")
    void testInvalidOperator() {
        // given
        String token = "!";

        // when, then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> inputValidator.validateOperator(token))
            .withMessage("Input is not a correct formula.");
    }

    @Test
    @DisplayName("입력 값의 토큰이 숫자가 아닌 경우")
    void testInvalidNumber() {
        // given
        String token = "+";

        // when, then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> inputValidator.validateNumber(token))
            .withMessage("Input is not a correct formula.");
    }

    @Test
    @DisplayName("입력 값이 빈 공백 문자인 경우")
    void testEmptyInput() {
        // given
        String input = "";

        // when, then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> inputValidator.validateBlank(input))
                .withMessage("Input is null or empty.");

    }

    @Test
    @DisplayName("입력 값이 Null인 경우")
    void testNullInput() {
        // given
        String input = null;

        // when, then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> inputValidator.validateBlank(input))
                .withMessage("Input is null or empty.");
    }
}
