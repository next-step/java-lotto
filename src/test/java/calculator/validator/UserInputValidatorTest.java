package calculator.validator;

import calculator.exception.ApplicationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputValidatorTest {

    @DisplayName("입력값이 비어 있거나 null 인 경우 예외를 던진다.")
    @Test
    void checkIfInputIsEmptyOrBlankTest() {
        String userInput1 = "";
        String userInput2 = null;

        assertThatThrownBy(() -> UserInputValidator.checkIfInputIsEmptyOrBlank(userInput1))
                .isInstanceOf(ApplicationException.class)
                .hasMessage("올바른 입력값이 아닙니다.");

        assertThatThrownBy(() -> UserInputValidator.checkIfInputIsEmptyOrBlank(userInput2))
                .isInstanceOf(ApplicationException.class)
                .hasMessage("올바른 입력값이 아닙니다.");

    }
}