package calculator.expression;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ExpressionTest {

    @Test
    void 수식_계산() {
        Expression expression = Expression.of("9 + 23 * 6 / 2");
        int result = expression.calculate();
        assertThat(result).isEqualTo(96);
    }
}
