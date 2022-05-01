package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("자연수 덧셈")
    void plus() {
        Calculator calculator = new Calculator();
        assertThat(calculator.plus("1", "3")).isEqualTo(4);
    }

    @Test
    @DisplayName("자연수 뺄셈")
    void mius() {
        Calculator calculator = new Calculator();
        assertThat(calculator.minus("3", "1")).isEqualTo(2);
        assertThat(calculator.minus("1", "3")).isEqualTo(-2);
    }

    @Test
    @DisplayName("자연수 곱셈")
    void multiply() {
        Calculator calculator = new Calculator();
        assertThat(calculator.multiply("3", "1")).isEqualTo(3);
        assertThat(calculator.multiply("1", "3")).isEqualTo(3);
    }

    @Test
    @DisplayName("자연수 나눗셈")
    void divide() {
        Calculator calculator = new Calculator();
        assertThat(calculator.divide("3", "1")).isEqualTo(3);
        assertThat(calculator.divide("1", "3")).isEqualTo(0);
    }

}
