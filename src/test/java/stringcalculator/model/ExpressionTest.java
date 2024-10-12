package stringcalculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionTest {

    @DisplayName("생성자 메서드는 입력이 유효하지 않으면, 에러를 반환한다.")
    @Test
    void 생성자_예외_테스트() {
        assertThatThrownBy(() -> Expression.createExpression(null))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("생성자 메서드는 입력이 유효하지 않으면, 에러를 반환한다.")
    @Test
    void 생성자_예외_테스트2() {
        assertThatThrownBy(() -> Expression.createExpression(" "))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 생서자_성공_테스트() {
        Expression expected = Expression.createExpression("1 + 2");

        assertThat(expected.getNextNumber()).isEqualTo(new Number(1));
        assertThat(expected.getNextNumber()).isEqualTo(new Number(2));
        assertThat(expected.getNextOperator()).isEqualTo(Operator.of("+"));
    }
}
