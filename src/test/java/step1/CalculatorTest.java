package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private static final Calculator CALCULATOR = new Calculator();

    @Test
    void 덧셈() {
        assertThat(CALCULATOR.plus(1, 2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(CALCULATOR.minus(2, 1)).isEqualTo(1);
    }

    @Test
    void 곱셈() {
        assertThat(CALCULATOR.multiply(2, 3)).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        assertThat(CALCULATOR.divide(6, 2)).isEqualTo(3);
    }
}
