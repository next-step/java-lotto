package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void 덧셈을_할_수_있다() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("2 + 3")).isEqualTo(5);
    }

    @Test
    void 뺄셈을_할_수_있다() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("4 - 2")).isEqualTo(2);
    }

    @Test
    void 곱셈을_할_수_있다() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("4 * 2")).isEqualTo(8);
    }

    @Test
    void 나눗셈을_할_수_있다() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("4 / 2")).isEqualTo(2);
    }
}
