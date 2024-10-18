package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import calculator.expression.Expression;
import calculator.expression.NumberExpression;
import calculator.tokenizer.SpaceExpressionTokenizer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ExpressionParserTest {

    @Test
    public void 사칙연산을_연속된_구조로_파싱_테스트() {
        ExpressionParser parser = new ExpressionParser(new SpaceExpressionTokenizer());

        Expression expression = parser.parse("2 + 3 * 4 / 2");

        assertThat(expression.calc()).isEqualTo(new NumberExpression(10));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 a 3","5"})
    public void 잘못된_문법_테스트(String value) {
        ExpressionParser parser = new ExpressionParser(new SpaceExpressionTokenizer());

        assertThatIllegalArgumentException().isThrownBy(()->parser.parse(value));
    }

}
