package com.seok2.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ManualLottoStrategyTest {

    @Test
    void generate() {
        LottoStrategy strategy = new ManualLottoStrategy(LottoSheetRow.of(1,2,3,4,5,6));
        assertThat(strategy.generate()).isEqualTo(Lotto.of(Auto.FALSE, 1, 2, 3, 4, 5, 6));

    }
}