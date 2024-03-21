package calculator;

import calculator.domain.Expression;
import calculator.domain.ExpressionElementBuilder;
import calculator.domain.Number;
import calculator.domain.Operator;
import calculator.exception.IllegalOperatorExpression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {

    @Test
    @DisplayName("[성공] 분리된 수식 요소들을 전달하면 숫자와 기호를 구분한다.")
    void 숫자_기호_구분() {
        // When
        Expression expression = new Expression(ExpressionElementBuilder.build(List.of("2", "+", "3", "*", "4", "/", "2")));

        // Then
        assertThat(expression.getNumbers()).containsExactlyInAnyOrder(new Number(2), new Number(3), new Number(4), new Number(2));
        assertThat(expression.getOperators()).containsExactlyInAnyOrder(new Operator("+"), new Operator("*"), new Operator("/"));
    }

    @Test
    @DisplayName("[실패] 형식에 맞지 않는 문자를 입력하면 IllegalOperatorExpression 예외가 발생한다.")
    void 형식에_맞지_않는_문자() {

        Assertions.assertThatExceptionOfType(IllegalOperatorExpression.class)
                .isThrownBy(() -> {
                    new Expression(ExpressionElementBuilder.build(List.of("2", "+", "3.")));
                }).withMessageContaining("잘못된 수식이 입력되었습니다. (입력 수식: 3.,");
    }
}
