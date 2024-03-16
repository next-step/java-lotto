package calculator;

import calculator.domain.Expression;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionTest {
    private static final String EXPRESSION= "2 + 3 * 4 / 2";

    @Test
    void 연산식_계산결과() {
        Expression expression = new Expression(EXPRESSION);
        assertThat(expression.result()).isEqualTo(10);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "2", "2+3", "2 +"})
    void 잘못된_연산식_생성(String input) {
        assertThatThrownBy(() -> new Expression(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
