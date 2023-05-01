package calculator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringExpressionParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"3 + 3 - 5", "3 / 3", "5 * 5 - 1 + 3"})
    void name(String value) {
        Expression expression = StringExpressionParser.parse(value);
        for (int i = 0; i < expression.size(); i++) {
            if (i % 2 == 0) {
                ExpressionElement oddElement = expression.get(i);
                assertThat(oddElement).isInstanceOf(Operand.class);
                continue;
            }
            ExpressionElement evenElement = expression.get(i);
            assertThat(evenElement).isInstanceOf(Operator.class);
        }
    }

    @Test
    void null_입력시_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> StringExpressionParser.parse(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void blank_입력시_IllegalArgumentException(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringExpressionParser.parse(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 +", "3 + 3 +"})
    void 연산_요소의_총_개수가_짝수일시_IllegalArgumentException(String value) {
        assertThatIllegalArgumentException().isThrownBy((() -> StringExpressionParser.parse(value)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 3", "3 + +"})
    void 숫자_또는_연산자_연속시_IllegalArgumentException(String value) {
        assertThatIllegalArgumentException().isThrownBy((() -> StringExpressionParser.parse(value)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+ 3", "+ 3 +"})
    void 연산자가_먼저인_경우_IllegalArgumentException(String value) {
        assertThatIllegalArgumentException().isThrownBy((() -> StringExpressionParser.parse(value)));
    }
}
