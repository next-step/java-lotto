package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {
    @Test
    void 덧셈() {
        Calculator calculator = new Calculator();
        assertThat(calculator.add(1, 2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        Calculator calculator = new Calculator();
        assertThat(calculator.subtract(1, 2)).isEqualTo(-1);
    }
}
