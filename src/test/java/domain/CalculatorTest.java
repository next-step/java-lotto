package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 덧셈(){
        int result = Calculator.plus(2, 3);
        Assertions.assertThat(result).isEqualTo(5);
    }
}
