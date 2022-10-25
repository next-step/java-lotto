import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {

    @Test
    void plus() {
        Calculator calculator = new Calculator("1 + 2");
        int result = calculator.plus(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void minus() {
        Calculator calculator = new Calculator("3 - 1");
        int result = calculator.minus(3, 1);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void multiply() {
        Calculator calculator = new Calculator("3 * 2");
        int result = calculator.multiply(3, 2);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void divide() {
        Calculator calculator = new Calculator("6 / 2");
        int result = calculator.divide(6, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void divideIntegerCheck() {
        assertThatThrownBy(() ->{
            Calculator calculator = new Calculator("3 / 2");
            int result = calculator.divide(3, 2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void divideZeroCheck() {
        assertThatThrownBy(() ->{
            Calculator calculator = new Calculator("3 / 0");
            int result = calculator.divide(3, 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void emptyInput(String input) {
        assertThatThrownBy(() ->{
            Calculator calculator = new Calculator(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculate() {
        Calculator calculator = new Calculator("1 + 2 * 4 / 2");
        int result = calculator.result();
        assertThat(result).isEqualTo(6);
    }
}
