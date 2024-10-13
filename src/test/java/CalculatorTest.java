import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void 덧셈 () {
        Calculator calculator = new Calculator();

        assertThat(calculator.add(3, 4)).isEqualTo(7);
    }

    @Test
    public void 뺄셈 () {
        Calculator calculator = new Calculator();

        assertThat(calculator.substract(7,4)).isEqualTo(3);
    }

    @Test
    public void 곱셈 () {
        Calculator calculator = new Calculator();

        assertThat(calculator.multiply(3, 4)).isEqualTo(12);
    }

    @Test
    public void 나눗셈 () {
        Calculator calculator = new Calculator();

        assertThat(calculator.devide(6, 3)).isEqualTo(2);
    }
}
