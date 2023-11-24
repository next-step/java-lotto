package com.fineroot.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.lotto.dto.LotteryCount;
import org.junit.jupiter.api.Test;

class LotteryOrderTest {
    @Test
    void create() {
        LotteryOrder lotteryOrder = LotteryOrder.of(LotteryCount.from(10), LottoBundle.from(4));
        assertThat(lotteryOrder).isInstanceOf(LotteryOrder.class);
    }

    @Test
    void lottoBundle() {
        LotteryOrder lotteryOrder = LotteryOrder.of(LotteryCount.from(10), LottoBundle.from(4));
        assertThat(lotteryOrder.lottoBundle().size()).isEqualTo(14);
    }
}
