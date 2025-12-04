package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputExpressionTest {
    @Test
    @DisplayName("null 입력은 예외")
    void nullInput() {
        assertThatThrownBy(() -> new InputExpression(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백 입력은 예외")
    void blankInput() {
        assertThatThrownBy(() -> new InputExpression("   "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백 기준으로 토큰을 분리한다")
    void splitBySpace() {
        InputExpression expression = new InputExpression("2 + 3 * 4");

        List<String> tokens = expression.splitBy(" ");

        assertThat(tokens)
            .containsExactly("2", "+", "3", "*", "4");
    }
}
