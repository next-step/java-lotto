package lotto;

import lotto.domain.Expression;
import lotto.exception.IllegalOperatorExpression;
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
        Expression expression = new Expression(List.of("2", "+", "3", "*", "4", "/", "2"));

        // Then
        assertThat(expression.getNumbers()).containsExactlyInAnyOrder(2, 3, 4, 2);
        assertThat(expression.getOperators()).containsExactlyInAnyOrder("+", "*", "/");
    }

    @Test
    @DisplayName("[실패] 형식에 맞지 않는 문자를 입력하면 IllegalOperatorExpression 예외가 발생한다.")
    void 형식에_맞지_않는_문자() {

        Assertions.assertThatExceptionOfType(IllegalOperatorExpression.class)
                .isThrownBy(() -> {
                    new Expression(List.of("2", "+", "3."));
                }).withMessage("잘못된 수식이 입력되었습니다. (입력 수식: 3., 허용 수식: [ + - * / ])");
    }
}
