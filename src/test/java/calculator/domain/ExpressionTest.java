package calculator.domain;

import static calculator.config.CalculatorExceptionMessage.EXPRESSION_CANNOT_BE_NULL_OR_EMPTY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class ExpressionTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 1", "1 + 1 - 1", "1 * 2 - 3 / 4"})
    @DisplayName("계산식을 연산자와 피연산자 토큰들로 저장한다.")
    void Expression_OperandsAndOperators(final String text) {
        final String[] tokens = text.split(" ");

        assertThat(Expression.from(tokens))
                .isNotNull();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("계산식 배열이 null이거나 빈 배열인 경우 예외를 던진다.")
    void Expression_NullAndEmpty_Exception(final String[] nullOrEmptyTokens) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Expression.from(nullOrEmptyTokens))
                .withMessage(EXPRESSION_CANNOT_BE_NULL_OR_EMPTY.message(nullOrEmptyTokens));
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 1,2", "1 - 1,0", "2 * 3,6", "4 / 2,2", "2 + 3 * 4 / 2,10", "5 - 1 * 3 / 4 + 3,6"})
    @DisplayName("계산식의 계산을 수행하고 결과를 반환한다.")
    void Calculate_Expression(final String text, final int result) {
        final String[] tokens = text.split(" ");
        final Expression expression = Expression.from(tokens);

        assertThat(expression.calculate())
                .isEqualTo(new Operand(result));
    }
}
