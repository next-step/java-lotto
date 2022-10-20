package lotto.domain;

import lotto.exception.ErrorCode;
import lotto.exception.LotteryGameException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceTest {
    @Test
    void under_zero() {
        assertThatThrownBy(() -> new Price(0))
                .isInstanceOf(LotteryGameException.class)
                .hasMessage(ErrorCode.OUT_OF_RANGE_PRICE.getMessage());
    }

    @Test
    void calculate_amount() {
        assertThat(new Price(10000).calculateAmount(new Price(1000))).isEqualTo(new Amount(10));
    }
}
