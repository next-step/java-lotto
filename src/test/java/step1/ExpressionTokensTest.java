package step1;

import org.junit.jupiter.api.Test;
import step1.domain.Operands;
import step1.domain.Operators;
import step1.util.ExpressionTokens;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionTokensTest {
    @Test
    void splitToken() {
        String input = "2 + 3 * 4 / 2";
        String[] inputStrings = input.split(" ");

        Operands operands = ExpressionTokens.filterOperands(inputStrings);
        Operators operators = ExpressionTokens.filterOperators(inputStrings);

        assertThat(operands.getOperands()).hasSize(4);
        assertThat(operators.getOperators()).hasSize(3);
    }
}
