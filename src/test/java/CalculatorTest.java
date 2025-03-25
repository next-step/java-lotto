import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    @Test
    void add() {
        int result = Calculator.add(3, 2);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void subtract() {
        int result = Calculator.subtract(3, 2);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void multiply() {
        int result = Calculator.multiply(3, 2);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void divide() {
        int result = Calculator.divide(6, 3);
        assertThat(result).isEqualTo(2);
    }
}
