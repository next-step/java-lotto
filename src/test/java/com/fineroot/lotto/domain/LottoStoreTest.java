package com.fineroot.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.lotto.domain.vo.LotteryCount;
import com.fineroot.lotto.dto.LotteryOrderSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreTest {
    @Test
    @DisplayName("LottoStore 생성")
    void create() {
        LottoStore store = new LottoStore();
        assertThat(store).isInstanceOf(LottoStore.class);
    }

    @Test
    @DisplayName("Lotto 구매: Order 넘겨받기")
    void purchaseLottery_WithLotteryOrder() {
        LottoStore store = new LottoStore();
        LotteryCount manualLotteryCount = LotteryCount.from(4);
        store.purchaseLottery(
                LotteryOrder.of(LotteryOrderSet.of(LottoPayment.from(14000), manualLotteryCount),
                        LottoBundle.fromLotteryCount(manualLotteryCount)));
        assertThat(store.lottoBundleStatus().size()).isEqualTo(14);
    }
}
