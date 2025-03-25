package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionTest {
    @Test
    @DisplayName("입력 값이 없을 경우, 예외를 반환한다.")
    void emptyExpressionTest() {
        String input = "";
        assertThatThrownBy(() -> {
            Expression expression = new Expression(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 없습니다.");
    }

    @Test
    @DisplayName("입력 값이 null일 경우, 예외를 반환한다.")
    void nullExpressionTest() {
        String input = null;
        assertThatThrownBy(() -> {
            Expression expression = new Expression(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 없습니다.");
    }

    @Test
    @DisplayName("올바르지 않은 식이 입력되었을 경우, 예외를 반환한다.")
    void invalidExpressionTest() {
        String input = "2 + 3 +";
        assertThatThrownBy(() -> {
            Expression expression = new Expression(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바른 식이 아닙니다.");
    }

    @Test
    @DisplayName("계산을 제대로 하는지 확인한다")
    void calcTest() {
        String input = "2 + 3 * 4 / 2";
        Expression expression = new Expression(input);
        assertThat(expression.calc()).isEqualTo(10);
    }

    @Test
    @DisplayName("공백이 아닌 구분자로 입력되었을 때, 예외를 반환한다.")
    void invalidDelimiterTest() {
        String input = "2+3*4/2";
        assertThatThrownBy(() -> {
            Expression expression = new Expression(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 값이 입력되었습니다. 값 : 2+3*4/2");
    }
}
