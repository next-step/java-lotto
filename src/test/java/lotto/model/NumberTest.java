package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @Test
    void IfNumberZeroThrowException() {
        assertThatThrownBy(() -> Number.of(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void ifNumberHigherThan45ThrowException() {
        assertThatThrownBy(() -> Number.of(46)).isInstanceOf(IllegalArgumentException.class);
    }
}
