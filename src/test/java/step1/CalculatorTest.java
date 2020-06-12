package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    void sum() {
        Calculator calculator = new Calculator();
        int result = calculator.sum("1,2");
        assertThat(result).isEqualTo(3);

    }
}
