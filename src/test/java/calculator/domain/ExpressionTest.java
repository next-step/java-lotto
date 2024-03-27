package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import calculator.domain.parser.ArithmeticParser;
import calculator.domain.parser.Parser;

class ExpressionTest {

    private final Parser parser = new ArithmeticParser();

    @ParameterizedTest
    @CsvSource(value = {"1 + 1", "1 + 1 - 1", "1 * 2 - 3 / 4"})
    @DisplayName("계산식을 연산자와 피연산자 토큰들로 저장한다.")
    void Expression_OperandsAndOperators(final String text) {
        assertThat(Expression.of(text, parser))
                .isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 1,2", "1 - 1,0", "2 * 3,6", "4 / 2,2", "2 + 3 * 4 / 2,10", "5 - 1 * 3 / 4 + 3,6"})
    @DisplayName("계산식의 계산을 수행하고 결과를 반환한다.")
    void Calculate_Expression(final String text, final int result) {
        final Expression expression = Expression.of(text, parser);

        assertThat(expression.calculate())
                .isEqualTo(result);
    }
}
