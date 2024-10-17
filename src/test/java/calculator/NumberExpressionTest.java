package calculator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class NumberExpressionTest {

    @Test
    public void 숫자형식_검사() {
        assertThatIllegalArgumentException().isThrownBy(() -> new NumberExpression("a"));
    }
}
