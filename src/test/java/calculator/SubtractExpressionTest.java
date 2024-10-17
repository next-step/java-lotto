package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SubtractExpressionTest {

    @Test
    public void 연속된_빼기_테스트(){
        Expression leftExpression = new SubtractExpression(new NumberExpression(10),new NumberExpression(5));
        Expression expression = new SubtractExpression(leftExpression,new NumberExpression(5));

        NumberExpression calc = expression.calc();

        assertThat(calc).isEqualTo(new NumberExpression(0));
    }

}
