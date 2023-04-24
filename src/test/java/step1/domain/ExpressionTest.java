package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

public class ExpressionTest {

    @Test
    @DisplayName("계산식이 올바른 형태인지 검증한다.")
    void testExpressionValidation() {
        String expression = "2 + 3 * 4 / 2";

        assertThatNoException().isThrownBy(() -> new Expression(expression));
    }

    @Test
    @DisplayName("계산식이 올바르지 않은 형태이면 예외를 리턴한다.")
    void testThrowExceptionWhenExpressionIsNotValid() {
        String expression = "2 + 3 * 4 / / 2";

        assertThatIllegalArgumentException().isThrownBy(() -> new Expression(expression));
    }

    @Test
    @DisplayName("계산식이 공백이면 예외를 리턴한다.")
    void testThrowExceptionWhenExpressionIsBlank() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Expression(" "));
        assertThatIllegalArgumentException().isThrownBy(() -> new Expression(null));
    }
}
