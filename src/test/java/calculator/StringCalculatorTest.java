 package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    StringCalculator calculator;

    @BeforeEach
    @Test
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName("입력값을 숫자로 분리")
    @Test
    void calculate() {
        int result = calculator.calculate("2 + 3 * 4 / 2");

        assertThat(result).isEqualTo(10);
    }

    @Test
    void add() {
        int result = calculator.add(10, 20);

        assertThat(result).isEqualTo(30);
    }

    @Test
    void subtract() {
        int result = calculator.subtract(20, 10);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void multiply() {
        int result = calculator.multiply(10, 20);

        assertThat(result).isEqualTo(200);
    }

    @Test
    void divide() {
        int result = calculator.divide(20, 5);

        assertThat(result).isEqualTo(4);
    }

    @DisplayName("0으로 나누면 예외 발생")
    @Test
    void divideZero() {
        assertThatThrownBy(() -> calculator.divide(20, 0)).isInstanceOf(IllegalArgumentException.class);
    }
}
