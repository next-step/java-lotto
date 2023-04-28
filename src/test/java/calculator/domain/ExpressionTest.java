package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ExpressionTest {
    @Test
    @DisplayName("공백 테스트")
    void blank() {
        String input = "";

        assertThatThrownBy(() -> {
            new Expression(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력값이 빈칸입니다.");
    }

    @Test
    @DisplayName("숫자가 없을 경우")
    void checkNum() {
        String input = "+ - *";

        assertThatThrownBy(() -> {
            new Expression(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력 형식에 맞지 않습니다.");
    }

    @Test
    @DisplayName("기호가 없을 경우")
    void checkOperation() {
        String input = "3 4 12";

        assertThatThrownBy(() -> {
            new Expression(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력 형식에 맞지 않습니다.");
    }

    @Test
    @DisplayName("split 테스트")
    void split() {
        String input = "2 + 3 * 4 / 2";
        List<String> expected = Arrays.asList("2", "+", "3", "*", "4", "/", "2");

        Expression expression = new Expression(input);
        assertThat(expression.getElements()).containsExactlyElementsOf(expected);
    }
}
