package step1.controller.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.utils.ExpressionSplitter;

class ExpressionSplitterTest {

    @Test
    @DisplayName("입력한 사칙연산을 토큰으로 분리할 수 있다.")
    void splitExpression() {
        String expression = "2 * 3";
        assertThat(ExpressionSplitter.splitExpression(expression)).contains("2", "*", "3");
    }
}