package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {
    @Test
    public void parseAdditionsToExpression() {
        var input = "2 + 3 + 4";

        var expression = new Expression(input);

        assertThat(expression.operands).containsExactly(2, 3, 4);
        assertThat(expression.operators).containsExactly(Operator.ADD, Operator.ADD);
    }
}
