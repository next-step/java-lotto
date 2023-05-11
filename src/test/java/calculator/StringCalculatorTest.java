package calculator;

import org.junit.jupiter.api.Test;

import static calculator.Operator.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {
    @Test
    void add() {
        assertThat(PLUS.apply(3, 4)).isEqualTo(7);
    }
    @Test
    void subtract() {
        assertThat(MINUS.apply(3, 4)).isEqualTo(-1);
    }
    @Test
    void multiply() {
        assertThat(MULTIPLY.apply(3, 4)).isEqualTo(12);
    }
    @Test
    void divide() {
        assertThat(DIVIDE.apply(3, 4)).isEqualTo(0);
    }
    @Test
    void calculate() {
        assertThat(StringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
        assertThat(StringCalculator.calculate("1 - 2 * 3 / 2")).isEqualTo(-1);
    }
}
