package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class ExpressionTest {

    @ParameterizedTest
    @CsvSource(value = {"0=1", "1 + 2=3", "1 + 2 / 3=5"}, delimiter = '=')
    @DisplayName("공백 기준으로 문자열이 분리가 잘 되어야 한다")
    public void parseByDelimiter(String expression, int count) {
        List<String> tokens = Expression.parse(expression);

        Assertions.assertThat(tokens).hasSize(count);
    }

}