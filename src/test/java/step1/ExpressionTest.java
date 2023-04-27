package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {
    Expression expression = new Expression(new String[]{"2", "+", "3", "*", "4", "/", "2", "-", "1"});

    @Test
    void 식계산() {
        assertThat(expression.calculate()).isEqualTo(9);
    }

    @Test
    void 사칙연산() {
        assertThat(expression.operate(2, "+", 3)).isEqualTo(5);
        assertThat(expression.operate(5, "*", 4)).isEqualTo(20);
        assertThat(expression.operate(20, "/", 2)).isEqualTo(10);
        assertThat(expression.operate(10, "-", 1)).isEqualTo(9);
    }
}
