package calculator;

import calculator.domain.Expression;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3,5", "2 + 3 * 4 / 2,10", "9 / 3 - 1,2"})
    void 연산식_계산결과(String input, int expected) {
        Expression expression = new Expression(input);
        assertThat(expression.result()).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "2", "2+3", "2 +"})
    void 잘못된_연산식_생성(String input) {
        assertThatThrownBy(() -> new Expression(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
