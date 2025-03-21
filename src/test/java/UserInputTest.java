import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
