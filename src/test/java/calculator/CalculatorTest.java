package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void testGetInstance(){
        Calculator calculator = Calculator.getInstance();
        Assertions.assertThat(calculator)
                .isEqualTo(Calculator.getInstance());
    }
}
