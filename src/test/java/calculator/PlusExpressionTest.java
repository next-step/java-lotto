package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PlusExpressionTest {

    @Test
    public void 더하기_테스트() {
        PlusExpression plusExpression = new PlusExpression(new NumberExpression(5), new NumberExpression(5));
        NumberExpression result = plusExpression.calc();
        assertThat(result).isEqualTo(new NumberExpression(10));
    }
}
