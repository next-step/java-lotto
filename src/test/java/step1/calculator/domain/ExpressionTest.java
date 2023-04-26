package step1.calculator.domain;

import org.junit.jupiter.api.Test;
import step1.calculator.domain.Expression;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionTest {

    @Test
    void expressionCalculateTest() {
        Expression expression = Expression.from(List.of(1, 2, 3, 4, 5, 2), List.of("*", "+", "-", "+", "/"));

        assertThat(expression.getCalculateResult())
                .isEqualTo(3);
    }
}
