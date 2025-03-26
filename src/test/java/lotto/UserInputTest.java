package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class UserInputTest {
    @Test
    @DisplayName("입력 값이 null일 경우 예외를 던진다")
    void nullInputTest() {
        String input = null;
        assertThatThrownBy(() -> calculator.UserInput.fromStringInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "입력 값이 빈 공백 문자거나 숫자가 아닐 경우 예외를 던진다")
    @ValueSource(strings = {
            "   ",
            "##",
            "a"
    })
    void blankInputTest(String input) {
        assertThatThrownBy(() -> calculator.UserInput.fromStringInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
