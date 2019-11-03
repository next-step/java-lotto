package firststep;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {


    private final Calculator calculator = new Calculator();
    @Test
    @DisplayName("숫자를 합한다")
    void calculate() {
        String[] input = new String[]{"1","2","3"};
        assertThat(calculator.calculate(input)).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자를 0 을 return 한다")
    void calculate2() {
        String[] input = new String[]{"0"};
        assertThat(calculator.calculate(input)).isEqualTo(0);
    }

    @Test
    @DisplayName("음수는 RuntimeException")
    void calculate3() {
        String[] input = new String[]{"-1"};
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(()->calculator.calculate(input));
    }

    @Test
    @DisplayName("숫자가 아니면 RuntimeException")
    void calculate4() {
        String[] input = new String[]{"test"};
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(()->calculator.calculate(input));
    }

}
