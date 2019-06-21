package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.Expression.DEFAULT_DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {

    @Test
    void createExpressionByDefaultExpression() {
        String inputOfString = "1,2,3";
        Expression result =  Expression.from(inputOfString);
        assertThat(result).isNotNull();
        assertThat(result.getDelimiter()).isEqualTo(DEFAULT_DELIMITER);
        assertThat(result.getTokens()).isEqualTo(inputOfString);
    }

    @ParameterizedTest
    @CsvSource({
            "'//;\n1;2;3', ';', '1;2;3'",
            "'//a\n1a2a3', 'a', '1a2a3'"
    })
    void sumByInputWithCustomDelimiter(String inputOfEmpty, String delimiter, String token) {
        Expression expression =  Expression.from(inputOfEmpty);
        assertThat(expression.getDelimiter()).isEqualTo(delimiter);
        assertThat(expression.getTokens()).isEqualTo(token);
    }

    @Test
    void createExpressionByDefaultExpression2() {
        String delimiter = ",";
        String expression = "1,2,3";
        Expression result = new Expression(delimiter, expression);
        assertThat(result).isNotNull();
        assertThat(result.getDelimiter()).isEqualTo(delimiter);
        assertThat(result.getTokens()).isEqualTo(expression);
    }
}
