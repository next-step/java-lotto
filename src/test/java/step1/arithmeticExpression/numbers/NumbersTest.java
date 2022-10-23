package step1.arithmeticExpression.numbers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step1.arithmeticExpression.operators.ExpressionAsOperators;
import step1.arithmeticExpression.operators.Operators;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @Test
    void 숫자들은_계산을_할_수있다() {
        String expression  = "1 + 1 * 2";
        Numbers sut = new Numbers(new ExpressionAsNumbers(expression));

        Operators operators = new Operators(new ExpressionAsOperators(expression));
        assertThat(sut.calculatedResult(operators)).isEqualTo(4);
    }

    @Test
    void 계산을_할_때_올바른_연산자가_아닐_경우_예외가_발생한다() {
        String expression  = "1 + 2";
        Numbers sut = new Numbers(new ExpressionAsNumbers(expression));

        String anotherExpression = "1 / 2 + 3";
        Operators operators = new Operators(new ExpressionAsOperators(anotherExpression));

        Assertions.assertThatThrownBy(() -> sut.calculatedResult(operators))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 연산자가 아닙니다.");
    }
}
