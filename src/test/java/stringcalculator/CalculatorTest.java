package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("사칙 연산 확인")
    void testMultipleOperations() {
        // given
        String input = "2 + 3 * 4 / 2";

        // when
        int result = calculator.calculate(input);

        // then
        assertThat(result).isEqualTo(10);

    }

    @Test
    @DisplayName("입력 값이 사칙 연산 기호가 아닌 경우")
    void testInvalidInput() {
        // given
        String input = "2 ! 3 * 4";

        // when, then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(input))
                .withMessage("Input is not a correct formula.");
    }

    @Test
    @DisplayName("입력 값이 빈 공백 문자인 경우")
    void testEmptyInput() {
        // given
        String input = "";

        // when, then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(input))
                .withMessage("Input is null or empty.");

    }

    @Test
    @DisplayName("입력 값이 Null인 경우")
    void testNullInput() {
        // given
        String input = null;

        // when, then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(input))
                .withMessage("Input is null or empty.");
    }
}
