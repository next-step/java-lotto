package com.seok2.lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import com.seok2.lotto.domain.lotto.Lotto;
import com.seok2.lotto.domain.order.LottoSheetRow;
import com.seok2.lotto.domain.lotto.LottoStrategy;
import com.seok2.lotto.domain.lotto.ManualLottoStrategy;
import org.junit.jupiter.api.Test;

class ManualLottoStrategyTest {

    @Test
    void generate() {
        LottoStrategy strategy = new ManualLottoStrategy(LottoSheetRow.of(1,2,3,4,5,6));
        assertThat(strategy.generate()).isEqualTo(Lotto.manual(1, 2, 3, 4, 5, 6));

    }
}