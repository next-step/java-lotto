package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();


    @Test
    @DisplayName("사칙연산 확인")
    void testMultipleOperations() {
        // given
        String input = "2 + 3 * 4 / 2";

        // when
        int result = calculator.calculate(input);

        // then
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("사칙연산이 아닌 케이스가 포함된 겨우")
    void testInvalidInput() {
        // given
        String input = "10 + 5 ! 2 - 4";

        // when , then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(input))
                .withMessage("Input is nonArithmeticOperator.");
    }

    @Test
    @DisplayName("input 값이 공백인 경우")
    void testEmptyInput() {
        // given
        String input = "";

        // when , then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(input))
                .withMessage("Input is null or empty.");
    }

    @Test
    @DisplayName("input 값이 null인 경우")
    void testNullInput() {
        // given
        String input = null;

        // when , then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(input))
                .withMessage("Input is null or empty.");
    }
}
