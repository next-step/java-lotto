package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExpressionTest {
    @Test
    @DisplayName("기호와 숫자 분리")
    public void 기호_숫자_분리() {
        Assertions.assertThat(Expression.split("1  + 2     - 3  * 4  ").size())
                .isEqualTo(7);
        Assertions.assertThat(Expression.split("  1 + - 2 - 3 * 4 2 ").get(1))
                .isEqualTo("+");
    }

    @ParameterizedTest
    @CsvSource({"1, true", "1 + 2, false"})
    public void 숫자_하나(String input, boolean expected) {
        Assertions.assertThat(new Expression(input).isMonomial())
                .isEqualTo(expected);
    }

}
