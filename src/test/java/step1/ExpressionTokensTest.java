package step1;

import org.junit.jupiter.api.Test;
import step1.domain.Expression;
import step1.domain.Operands;
import step1.domain.Operators;
import step1.util.ExpressionTokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExpressionTokensTest {
    private Expression expr(String input) {
        return new Expression(ExpressionTokens.parseTokens(input));
    }
    @Test
    void splitToken() {
        Expression expression = expr("3 + 5 * 2 / 10");

        Operands operands = expression.generateOperands();
        Operators operators = expression.generateOperators();

        assertThat(operands.getOperands()).hasSize(4);
        assertThat(operators.getOperators()).hasSize(3);
    }

    @Test
    void validTokenException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> expr("3 3 * 4"));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> expr("3 * 3 * 4 /"));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> expr("3 * 3 */ 4"));
    }
}
