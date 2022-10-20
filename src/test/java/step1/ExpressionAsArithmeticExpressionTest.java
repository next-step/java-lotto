package step1;

import org.junit.jupiter.api.Test;
import step1.numbers.ExpressionAsNumbers;
import step1.numbers.Numbers;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionAsArithmeticExpressionTest {

    @Test
    void 표현식을_숫자로_추출할_수있다() {
        String expression = "1 + 1";
        ExpressionAsArithmeticExpression sut = new ExpressionAsArithmeticExpression(expression);

        assertThat(sut.numbers()).isEqualTo(new Numbers(new ExpressionAsNumbers(expression)));
    }
}
