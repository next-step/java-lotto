package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExpressionTest {

    @DisplayName("expression이 null이면 예외가 발생한다.")
    @Test
    void when_InputIsNull_ThrowException() {
        String expression = null;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Expression(expression));
    }

    @DisplayName("expression이 공백이면 예외가 발생한다.")
    @Test
    void when_InputIsBlank_ThrowException() {
        String expression = "     ";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Expression(expression));
    }

    @DisplayName("expression을 parse할때 사칙연산을 제외한 값이 있을 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1 ++ 3 / 2", "-2 & 3", "-2 // 3", "-2 -- -3"})
    void when_ExpressionContainsWrongOperations_ThrowException(String expression) {

        Expression expression1 = new Expression(expression);

        assertThatIllegalArgumentException()
                .isThrownBy(expression1::parseToList);
    }
}