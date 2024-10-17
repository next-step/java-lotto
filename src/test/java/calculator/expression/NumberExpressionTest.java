package calculator.expression;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import calculator.expression.NumberExpression;
import org.junit.jupiter.api.Test;

public class NumberExpressionTest {

    @Test
    public void 숫자형식_검사() {
        assertThatIllegalArgumentException().isThrownBy(() -> new NumberExpression("a"));
    }

}
