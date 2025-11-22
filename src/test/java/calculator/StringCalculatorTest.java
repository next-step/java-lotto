package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void add() {
        assertThat(Calculator.add(1, 2)).isEqualTo(3);
    }

    @Test
    void substract() {
        assertThat(Calculator.subtract(1, 0)).isEqualTo(1);
    }
}
