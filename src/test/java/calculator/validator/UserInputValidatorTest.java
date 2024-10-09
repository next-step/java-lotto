package calculator.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputValidatorTest {

    @DisplayName("입력값이 비어 있거나 null 인 경우 예외를 던진다.")
    @ParameterizedTest
    @NullAndEmptySource
    void checkIfInputIsEmptyOrBlankTest(String input) {
        assertThatThrownBy(() -> UserInputValidator.checkIfInputIsEmptyOrBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 입력값이 아닙니다.");
    }

}
