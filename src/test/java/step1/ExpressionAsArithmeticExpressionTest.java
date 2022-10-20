package step1;

import org.junit.jupiter.api.Test;
import step1.numbers.ExpressionAsNumbers;
import step1.numbers.Numbers;
import step1.operators.ExpressionAsOperators;
import step1.operators.Operators;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionAsArithmeticExpressionTest {

    @Test
    void 표현식을_숫자로_추출할_수있다() {
        String expression = "1 + 1";
        ExpressionAsArithmeticExpression sut = new ExpressionAsArithmeticExpression(expression);

        assertThat(sut.numbers()).isEqualTo(new Numbers(new ExpressionAsNumbers(expression)));
    }

    @Test
    void 표현식을_연산식으로_추출할_수있다() {
        String expression = "1 + 1";
        ExpressionAsArithmeticExpression sut = new ExpressionAsArithmeticExpression(expression);

        assertThat(sut.operators()).isEqualTo(new Operators(new ExpressionAsOperators(expression)));
    }
}
