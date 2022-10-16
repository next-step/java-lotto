package Lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddTest {
    @Test
    void 덧셈_연산() {
        assertThat(new Add().operate(1, 2)).isEqualTo(3);
    }
}
