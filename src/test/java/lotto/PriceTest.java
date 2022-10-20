package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceTest {
    @Test
    void under_zero() {
        assertThatThrownBy(() -> new Price(0))
                .isInstanceOf(LotteryGameException.class)
                .hasMessage(ErrorCode.OUT_OF_RANGE_PRICE.getMessage());
    }
}
