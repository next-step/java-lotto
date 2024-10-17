package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PlusExpressionTest {

    @Test
    public void 연속된_더하기_테스트() {
        PlusExpression leftExpression = new PlusExpression(new NumberExpression(5), new NumberExpression(5));
        PlusExpression expression = new PlusExpression(leftExpression, new NumberExpression(5));
        NumberExpression result = expression.calc();
        assertThat(result).isEqualTo(new NumberExpression(15));
    }
}
