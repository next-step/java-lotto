package string_calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArithmeticTest {
    @Test
    void add() {
        assertThat(Arithmetic.add(1, 2)).isEqualTo(3);
    }
}
