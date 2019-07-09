package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @DisplayName("숫자가 0일 경우 IllegalArgumentException 을 던진다.")
    @Test
    void IfNumberZeroThrowException() {
        assertThatThrownBy(() -> Number.of(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 46이상 일 경우 IllegalArgumentException 을 던진다.")
    @Test
    void ifNumberHigherThan45ThrowException() {
        assertThatThrownBy(() -> Number.of(46)).isInstanceOf(IllegalArgumentException.class);
    }
}
