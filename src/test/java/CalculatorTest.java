import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    @Test
    void plus() {
        Calculator calculator = new Calculator();
        int result = calculator.plus(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void minus() {
        Calculator calculator = new Calculator();
        int result = calculator.minus(3, 1);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void multiply() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(3, 2);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void divide() {
        Calculator calculator = new Calculator();
        int result = calculator.divide(6, 2);
        assertThat(result).isEqualTo(3);
    }
}
