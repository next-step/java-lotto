package com.fineroot.lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fineroot.lotto.domain.vo.LotteryCount;
import com.fineroot.lotto.util.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryOrderSetTest {
    @Test
    @DisplayName("생성 확인")
    void of() {
        assertThat(LotteryOrderSet.of(10000, 5)).isInstanceOf(LotteryOrderSet.class);
    }

    @Test
    @DisplayName("허용 범위 이탈 생성시 예외 확인")
    void of_should_throw_exception() {
        assertThatThrownBy(() -> LotteryOrderSet.of(1000, 2)).hasMessageContaining(
                ExceptionMessage.MANUAL_LOTTERY_COUNT_OUT_OF_BOUND.getMessage());
    }

    @Test
    @DisplayName("자동 매수 확인")
    void getAutoLotteryCount() {
        assertThat(LotteryOrderSet.of(2000, 1).getAutoLotteryCount()).isEqualTo(LotteryCount.from(1));
    }

    @Test
    @DisplayName("수동 매수 확인")
    void getManualLotteryCount() {
        assertThat(LotteryOrderSet.of(2000, 1).getManualLotteryCount()).isEqualTo(LotteryCount.from(1));
    }
}
