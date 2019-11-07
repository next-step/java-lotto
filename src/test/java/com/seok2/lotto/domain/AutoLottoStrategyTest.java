package com.seok2.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class AutoLottoStrategyTest {

    @Test
    void generate() {
        LottoStrategy strategy = new AutoLottoStrategy(Arrays.asList(1,2,3,4,5,6));
        assertThat(strategy.generate()).isEqualTo(Lotto.of(1,2,3,4,5,6));
    }
}