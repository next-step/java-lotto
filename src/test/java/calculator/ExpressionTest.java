package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExpressionTest {

    @Test
    void 입력값이_null일때_예외처리() {
        String expression = null;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Calculator(expression));
    }

    @Test
    void 입력값이_blank일때_예외처리() {
        String expression = "     ";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Calculator(expression));
    }
}