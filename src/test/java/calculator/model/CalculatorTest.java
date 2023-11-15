package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void 덧셈() {
        Assertions.assertThat(Calculator.add(1,2))
                .isEqualTo(3);
        Assertions.assertThat(Calculator.add(0,0))
                .isEqualTo(0);
    }

    @Test
    public void 뺄셈() {
        Assertions.assertThat(Calculator.sub(5,3))
                .isEqualTo(2);
        Assertions.assertThat(Calculator.sub(3,5))
                .isEqualTo(-2);
    }

    @Test
    public void 곱셈() {
        Assertions.assertThat(Calculator.multiple(2,3))
                .isEqualTo(6);
        Assertions.assertThat(Calculator.multiple(-2,3))
                .isEqualTo(-6);
        Assertions.assertThat(Calculator.multiple(2,0))
                .isEqualTo(0);
    }

    @Test
    public void 나눗셈() {
        Assertions.assertThat(Calculator.divide(4,2))
                .isEqualTo(2);
        Assertions.assertThat(Calculator.divide(-2,1))
                .isEqualTo(-2);
    }
}
