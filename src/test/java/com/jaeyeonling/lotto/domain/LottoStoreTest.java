package com.jaeyeonling.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @DisplayName("자동 구매 테스트")
    @Test
    void autoBuy() {
        final int countOfLotto = 10;
        final Money money = new Money(countOfLotto * Lotto.PRICE_VALUE);

        final List<Lotto> lottos = LottoStore.buyAutoByRemainingMoney(money);

        assertThat(lottos).hasSize(countOfLotto);
    }

}
