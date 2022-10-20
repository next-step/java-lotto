package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest {
    @Test
    void amount_under_zero() {
        assertThatThrownBy(() -> new Amount(0))
                .isInstanceOf(LotteryGameException.class)
                .hasMessage(ErrorCode.AMOUNT_UNDER_ZERO.getMessage());
    }

    @Test
    void amount_over_zero() {
        assertThatNoException().isThrownBy(() -> new Amount(1));
    }
}
