package calculator.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionsTest {
    final Expressions expressions = new Expressions();

    @Test
    void findExpression_해당_부호_객체_찾기() {
        Expression divide = expressions.findExpression("/");

        Expression expression = new Expression(CalculateExpression.DIVIDE);

        assertThat(divide).isEqualTo(expression);
    }

    @Test
    void findExpression_존재하지_않는_부호() {
        assertThatThrownBy(() -> expressions.findExpression("?")).isInstanceOf(IllegalArgumentException.class);
    }

}
