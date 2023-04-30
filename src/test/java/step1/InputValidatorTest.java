package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputValidatorTest {
    @Test
    @DisplayName("null 인경우 validation 확인")
    void whenInputIsNull() {
        // given
        String input = null;

        assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.isNotOrEmpty(input))
                .withMessage("Input is null or empty.");
    }

    @Test
    @DisplayName("empty 인경우 validation 확인")
    void whenInputIsEmpty() {
        // given
        String input = "";

        assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.isNotOrEmpty(input))
                .withMessage("Input is null or empty.");
    }

    @Test
    @DisplayName("사칙연산이 아닌경우 validation 확인")
    void whenInputIsNotArithmeticOperatorNorNumber() {
        // given
        String input = "abc";

        assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.nonArithmeticOperator(input))
                .withMessage("Input is nonArithmeticOperator.");
    }
}

