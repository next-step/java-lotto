package lotto.model;

import lotto.service.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBallTest {

    @Test
    void shouldValidateLottoBall() {
        assertThatThrownBy(() -> new LottoBall(RandomNumberGenerator.MAX_BOUND_NUM)).isInstanceOf(IllegalArgumentException.class);
    }
}
