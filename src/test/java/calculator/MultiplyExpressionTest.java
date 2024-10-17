package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MultiplyExpressionTest {

    @Test
    public void 연속된_곱하기_테스트() {
        Expression leftExpression = new MultiplyExpression(new NumberExpression(5), new NumberExpression(5));
        Expression expression = new MultiplyExpression(leftExpression, new NumberExpression(5));

        NumberExpression result = expression.calc();

        assertThat(result).isEqualTo(new NumberExpression(5 * 5 * 5));
    }
}
