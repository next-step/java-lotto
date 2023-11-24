package com.fineroot.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.lotto.dto.LotteryCount;
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
        store.purchaseLottery(
                LotteryOrder.of(LotteryCount.from(10), LottoBundle.fromLotteryCount(LotteryCount.from(4))));
        assertThat(store.lottoBundleStatus().size()).isEqualTo(14);
    }
}
