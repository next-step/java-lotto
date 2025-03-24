package calculator;

import caculator.Operator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OperatorTest {
    @Test
    public void 더하기() {
        assertThat(Operator.calculate("+", 1, 2)).isEqualTo(3);
    }

    @Test
    public void 빼기() {
        assertThat(Operator.calculate("-", 3, 2)).isEqualTo(1);
    }

    @Test
    public void 곱셈() {
        assertThat(Operator.calculate("*", 1, 2)).isEqualTo(2);
    }

    @Test
    public void 나누기() {
        assertThat(Operator.calculate("/", 4, 2)).isEqualTo(2);
    }

}
