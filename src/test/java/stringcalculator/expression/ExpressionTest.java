package stringcalculator.expression;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.common.ExceptionMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExpressionTest {

    @DisplayName("문자열계산식 객체 생성 - 정상적인 문자열 덧셈식")
    @ParameterizedTest
    @ValueSource(strings = {"1:2:3", "//;\\n1;2;3"})
    void newInstance(String expressionValue) {
        //when
        Expression expression = Expression.newInstance(expressionValue);

        //then
        assertThat(expression).isNotNull();
    }

    @DisplayName("문자열계산식 객체 생성 - 잘못된 문자열 덧셈식")
    @ParameterizedTest
    @ValueSource(strings = {"1::2;3", "\\n1?2?3", " "})
    void newInstanceWithWrongExpression(String expressionValue) {
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Expression.newInstance(expressionValue))
                .withMessage(ExceptionMessage.WRONG_EXPRESSION.printMessage());
    }

    @DisplayName("문자열계산식 객체 생성 - null 입력")
    @Test
    void newInstanceWithNullValue() {
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Expression.newInstance(null))
                .withMessage(ExceptionMessage.WRONG_EXPRESSION.printMessage());
    }
}
