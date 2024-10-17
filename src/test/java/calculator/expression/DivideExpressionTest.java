package calculator.expression;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class DivideExpressionTest {

    @Test
    public void 나누기_테스트() {
        Expression expression = new DivideExpression(new NumberExpression(5), new NumberExpression(3));

        NumberExpression result = expression.calc();

        assertThat(result).isEqualTo(new NumberExpression(5 / 3));
    }

    @Test
    public void 다중_나누기_테스트() {
        Expression divideExpression = new DivideExpression(new NumberExpression(30), new NumberExpression(7));
        Expression expression = new DivideExpression(divideExpression, new NumberExpression(3));

        NumberExpression result = expression.calc();

        assertThat(result).isEqualTo(new NumberExpression(30 / 7 / 3));
    }

}
