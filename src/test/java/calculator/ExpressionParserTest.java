package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.expression.Expression;
import calculator.expression.NumberExpression;
import org.junit.jupiter.api.Test;

public class ExpressionParserTest {

    @Test
    public void 사칙연산을_연속된_구조로_파싱_테스트() {
        ExpressionParser parser = new ExpressionParser(new SpaceExpressionTokenizer());

        Expression expression = parser.parse("2 + 3 * 4 / 2");

        assertThat(expression.calc()).isEqualTo(new NumberExpression(10));
    }

}
