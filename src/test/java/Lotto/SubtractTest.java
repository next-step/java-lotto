package Lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubtractTest {
    @Test
    void 연산() {
        assertThat(new Subtract().operate(2, 1)).isEqualTo(1);
    }
}
