package step1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ExpressionTest {

    @Test
    void expression() {
        Expression expression = new Expression("1,2:3");
        assertEquals(new Number(6), expression.sum());
    }

    @Test
    void sum() {
        Expression expression = new Expression("1,2:3");
        assertEquals(new Number(6), expression.sum());

        Expression customDelimiterExpression = new Expression("//;\n1;2;3");
        assertEquals(new Number(6), customDelimiterExpression.sum());
    }
}
