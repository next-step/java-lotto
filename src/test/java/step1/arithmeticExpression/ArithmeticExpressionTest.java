package step1.arithmeticExpression;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticExpressionTest {

    @Test
    void 연산을_할_수_있다() {
        ArithmeticExpression sut = new ArithmeticExpression(new ExpressionAsArithmeticExpression("1 + 1"));

        assertThat(sut.calculatedResult()).isEqualTo(2);
    }

}
