package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class NumberExpressionTest {

    @Test
    public void 숫자형식_검사() {
        assertThatIllegalArgumentException().isThrownBy(() -> new NumberExpression("a"));
    }

    @Test
    public void 더하기_테스트(){
        NumberExpression five = new NumberExpression(5);
        NumberExpression six = new NumberExpression(6);

        assertThat(five.sum(six)).isEqualTo(new NumberExpression(11));
    }
}