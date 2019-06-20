import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void addTwoNumber() {
        int num1 = 1;
        int num2 = 2;

        assertThat(Calculator.add(num1, num2)).isEqualTo(3);
    }
}
