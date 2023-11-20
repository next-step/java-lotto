package com.fineroot.lotto.entity;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.lotto.dto.Money;
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
    @DisplayName("Lotto 구매 금액 저장 & Lotto 구매 가능 개수")
    void purchaseLottery_howMuchLotto() {
        LottoStore store = new LottoStore();
        store.purchaseLottery(Money.from(10000));
        assertThat(store.howMuchLotto(Money.from(10000))).isEqualTo(10);
    }
}
