package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultipleTest {
    @Test
    void 곱셈_연산() {
        assertThat(new Multiple().operate(2, 3)).isEqualTo(6);
    }
}
