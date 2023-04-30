package stringCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {
    Expression expression = new Expression(new String[]{"2", "+", "3", "*", "4", "/", "2", "-", "1"});

    @Test
    void 식계산() {
        assertThat(expression.calculate()).isEqualTo(9);
    }
}
