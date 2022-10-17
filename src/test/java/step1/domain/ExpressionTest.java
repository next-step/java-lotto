package step1.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ExpressionTest {

    private final Expression expression = Expression.from("2 + 3 * 4 / 2");

    @Test
    public void 식을_구성하고_있는_피연산자_목록을_반환한다() {
        Operands operands = Operands.of(List.of("2", "3", "4", "2"));
        assertEquals(expression.getOperands(), operands);
    }

    @Test
    public void 식을_구성하고_있는_연산자_목록을_반환한다() {
        Operators operators = Operators.of(List.of("+", "*", "/"));
        assertEquals(expression.getOperators(), operators);
    }
}
