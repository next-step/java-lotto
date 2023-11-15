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
}
