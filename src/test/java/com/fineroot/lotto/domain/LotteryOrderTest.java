package com.fineroot.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.lotto.domain.vo.LotteryCount;
import com.fineroot.lotto.dto.LotteryOrderSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryOrderTest {
    @Test
    @DisplayName("생성 확인")
    void create() {
        LotteryCount manualLotteryCount = LotteryCount.from(4);
        LotteryOrder lotteryOrder = LotteryOrder.of(LotteryOrderSet.of(LottoPayment.from(10000), manualLotteryCount),
                LottoBundle.fromLotteryCount(manualLotteryCount));
        assertThat(lotteryOrder).isInstanceOf(LotteryOrder.class);
    }

    @Test
    @DisplayName("로또 번들 확인")
    void lottoBundle() {
        LotteryCount manualLotteryCount = LotteryCount.from(4);
        LotteryOrder lotteryOrder = LotteryOrder.of(LotteryOrderSet.of(LottoPayment.from(14000), manualLotteryCount),
                LottoBundle.fromLotteryCount(manualLotteryCount));
        assertThat(lotteryOrder.lottoBundle().size()).isEqualTo(14);
    }
}
