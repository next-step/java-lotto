package com.fineroot.lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fineroot.lotto.util.ExceptionMessage;
import org.junit.jupiter.api.Test;

class LotteryCountSetTest {
    @Test
    void of() {
        assertThat(LotteryCountSet.of(10, 5)).isInstanceOf(LotteryCountSet.class);
    }

    @Test
    void of_should_throw_exception() {
        assertThatThrownBy(() -> LotteryCountSet.of(1, 2)).hasMessageContaining(
                ExceptionMessage.MANUAL_LOTTERY_COUNT_OUT_OF_BOUND.getMessage());
    }

    @Test
    void getAutoLotteryCount() {
        assertThat(LotteryCountSet.of(2, 1).getAutoLotteryCount()).isEqualTo(LotteryCount.from(1));
    }

    @Test
    void getManualLotteryCount() {
        assertThat(LotteryCountSet.of(2, 1).getManualLotteryCount()).isEqualTo(LotteryCount.from(1));
    }
}
