package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoBallTest {

    @Test
    void create() {
        assertThat(new LottoBall(5)).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47, 101})
    void 범위를_넘어서는_LottoBall(int value) {
        assertThatThrownBy(() -> new LottoBall(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}