import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class UserInputTest {
    @Test
    @DisplayName("입력 값이 null일 경우 IllegalArgumentException를 던진다")
    void nullInputTest() {
        String input = null;
        assertThatThrownBy(() -> UserInput.fromStringInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값이 빈 공백 문자일 경우 IllegalArgumentException를 던진다")
    void blankInputTest() {
        String input = "  ";
        assertThatThrownBy(() -> UserInput.fromStringInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "잘못된 형식의 수식이 입력된 경우 IllegalArgumentException를 던진다. 수식: {0}")
    @ValueSource(strings = {
            "+",
            "1 2",
            "1 2 +",
            "1 + -"
    })
    void invalidExpressionTest(String input) {
        assertThatThrownBy(() -> UserInput.fromStringInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
