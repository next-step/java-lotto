package com.seok2.lotto.domain.order;

import static org.assertj.core.api.Assertions.assertThat;

import com.seok2.lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.Test;

class LottoSheetRowTest {

    @Test
    void exchange() {
        assertThat(LottoSheetRow.manual(1, 2, 3, 4, 5, 6).exchange()).isEqualTo(Lotto.manual(1, 2, 3, 4, 5, 6));
    }
}