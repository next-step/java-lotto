package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void 덧셈_값_계산() {
        Assertions.assertThat(Operator.add(2,5)).isEqualTo(7);
    }

    @Test
    public void 뺄셈_값_계산() {
        Assertions.assertThat(Operator.minus(2,5)).isEqualTo(-3);
    }

    @Test
    public void 곱셈_값_계산() {
        Assertions.assertThat(Operator.time(2,5)).isEqualTo(10);
    }

    @Test
    public void 나눗셈_값_계산() {
        Assertions.assertThat(Operator.dividedBy(10,5)).isEqualTo(2);
    }
}
