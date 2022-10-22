package step1.arithmeticExpression;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.arithmeticExpression.numbers.ExpressionAsNumbers;
import step1.arithmeticExpression.numbers.Numbers;
import step1.arithmeticExpression.operators.ExpressionAsOperators;
import step1.arithmeticExpression.operators.Operators;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "1 +",
            "+",
            "1+1"
    })
    void 올바르지_않는_연산식일_경우_예외가_발생한다(String expression) {
        ExpressionAsArithmeticExpression sut = new ExpressionAsArithmeticExpression(expression);

        assertAll(
                () -> assertThatThrownBy(() -> sut.numbers())
                        .isInstanceOf(IllegalStateException.class)
                        .hasMessage("유효한 연산식이 아닙니다."),

                () -> assertThatThrownBy(() -> sut.operators())
                        .isInstanceOf(IllegalStateException.class)
                        .hasMessage("유효한 연산식이 아닙니다.")
        );
    }

    @Test
    void 숫자0으로_나눌_경우_예외가_발생한다() {
        String expression = "1 / 0";
        ExpressionAsArithmeticExpression sut = new ExpressionAsArithmeticExpression(expression);

        assertAll(
                () -> assertThatThrownBy(() -> sut.numbers())
                        .isInstanceOf(IllegalStateException.class)
                        .hasMessage("0으로 나눌 수 없습니다."),

                () -> assertThatThrownBy(() -> sut.operators())
                        .isInstanceOf(IllegalStateException.class)
                        .hasMessage("0으로 나눌 수 없습니다.")
        );
    }
}
