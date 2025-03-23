import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 null이거나 빈 공백 문자열인 경우 예외를 반환한다.")
    public void nullAndEmptyExpression(String input) {
        assertThatThrownBy(() -> Expression.createExpression(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}