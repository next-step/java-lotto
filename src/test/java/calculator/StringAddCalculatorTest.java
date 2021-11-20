package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    private final StringAddCalculator calculator = new StringAddCalculator();

    @Test
    void calculate() {
        assertThat(calculator.calculate("")).isEqualTo(0);
        assertThat(calculator.calculate(null)).isEqualTo(0);
        assertThat(calculator.calculate("1,2")).isEqualTo(3);
        assertThat(calculator.calculate("1,2,3")).isEqualTo(6);
        assertThat(calculator.calculate("1,2:3")).isEqualTo(6);
        assertThat(calculator.calculate("//;\n1;2;3")).isEqualTo(6);
        assertThat(calculator.calculate("//;\n1,2:3;4")).isEqualTo(10);
        assertThat(calculator.calculate("//-\n1-2")).isEqualTo(3);
    }

    @Test
    void calculateFail() {
        assertThatThrownBy(() -> {
            calculator.calculate("-1");
        }).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> {
            calculator.calculate("-1,2");
        }).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> {
            calculator.calculate("a");
        }).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> {
            calculator.calculate("//-\n1--2");
        }).isInstanceOf(RuntimeException.class);
    }
    
}
