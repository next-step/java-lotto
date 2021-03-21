package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionTest {

    @Test
    @DisplayName("빈 문자열 또는 null일 경우 \"0\" 으로 변환")
    public void checkNullAndEmpty() throws Exception {
        Expression expression = new Expression(null);
        assertThat(expression.toString()).isEqualTo("0");

        expression = new Expression("");
        assertThat(expression.toString()).isEqualTo("0");
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외 발생")
    public void checkNegative() throws Exception {
        assertThatThrownBy(() -> new Expression("-1,2,3"))
                .isInstanceOf(RuntimeException.class).hasMessageContaining("음수가 포함");
    }
}