import org.junit.jupiter.api.Test;
import service.Calculator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void 문자열_계산기() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate(List.of(2, 3, 4, 2), List.of('+', '*', '/'))).isEqualTo(10);
    }

    @Test
    public void 덧셈() {
        Calculator calculator = new Calculator();

        assertThat(calculator.calculate(4, 2, '+')).isEqualTo(6);
    }

    @Test
    public void 뺄셈() {
        Calculator calculator = new Calculator();

        assertThat(calculator.calculate(4, 2, '-')).isEqualTo(2);
    }

    @Test
    public void 곱셈() {
        Calculator calculator = new Calculator();

        assertThat(calculator.calculate(4, 2, '*')).isEqualTo(8);
    }

    @Test
    public void 나눗셈() {
        Calculator calculator = new Calculator();

        assertThat(calculator.calculate(4, 2, '/')).isEqualTo(2);
    }
}
