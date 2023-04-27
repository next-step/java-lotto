package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {
    @Test
    public void parseAdditionsToExpression() {
        var input = "2 + 3 + 4";

        var expression = Expression.fromString(input);

        assertThat(expression.getOperands()).containsExactly(2, 3, 4);
        assertThat(expression.getOperators()).containsExactly(Operator.ADD, Operator.ADD);
    }

    @Test
    public void parseSubtractionsToExpression() {
        var input = "2 - 3 - 4";

        var expression = Expression.fromString(input);

        assertThat(expression.getOperands()).containsExactly(2, 3, 4);
        assertThat(expression.getOperators()).containsExactly(Operator.SUBTRACT, Operator.SUBTRACT);
    }

    @Test
    public void parseMultiplicationsToExpression() {
        var input = "2 * 3 * 4";

        var expression = Expression.fromString(input);

        assertThat(expression.getOperands()).containsExactly(2, 3, 4);
        assertThat(expression.getOperators()).containsExactly(Operator.MULTIPLY, Operator.MULTIPLY);
    }

    @Test
    public void parseDivisionsToExpression() {
        var input = "2 / 3 / 4";

        var expression = Expression.fromString(input);

        assertThat(expression.getOperands()).containsExactly(2, 3, 4);
        assertThat(expression.getOperators()).containsExactly(Operator.DIVIDE, Operator.DIVIDE);
    }
}
