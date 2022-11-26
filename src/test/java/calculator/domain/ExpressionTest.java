package calculator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExpressionTest {

    private static final String SINGLE_SPACE = " ";

    @Test
    void 수식은_null_불가() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Expression(null));
    }

    @Test
    void 수식은_공백_불가() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Expression(List.of(" ", "  ")));
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2 = 10", "22 + 3 * 4 / 2 = 50"}, delimiterString = " = ")
    void 순서대로_사칙연산(String rawExpressions, int expectedNumber) {
        Expression expressions = new Expression(splitExpressions(rawExpressions));
        assertThat(expressions.calculate()).isEqualTo(expectedNumber);
    }

    private List<String> splitExpressions(String rawExpressions) {
        return List.of(rawExpressions.split(SINGLE_SPACE));
    }
}