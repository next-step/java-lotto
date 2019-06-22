package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.Expression.DEFAULT_DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {

    @DisplayName("default 구분자를 사용하여 토큰, 구분자 생성한다")
    @ParameterizedTest
    @ValueSource( strings = { "1,2,3",
                              "'1,2:3",
                              "'1:2:3" })
    void createExpressionByDefaultExpression(String expression) {
        Expression result =  Expression.from(expression);
        assertThat(result).isNotNull();
        assertThat(result.getDelimiter()).isEqualTo(DEFAULT_DELIMITER);
        assertThat(result.getTokens()).isEqualTo(expression);
    }

    @DisplayName("커스텀 구분자를 사용하여 토큰, 구분자 생성한다")
    @ParameterizedTest
    @CsvSource({
            "'//;\n1;2;3', ';', '1;2;3'",
            "'//a\n1a2a3', 'a', '1a2a3'"
    })
    void sumByInputWithCustomDelimiter(String expression, String delimiter, String token) {
        Expression result =  Expression.from(expression);
        assertThat(result.getDelimiter()).isEqualTo(delimiter);
        assertThat(result.getTokens()).isEqualTo(token);
    }
}
