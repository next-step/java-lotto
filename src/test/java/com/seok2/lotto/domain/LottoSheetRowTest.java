package com.seok2.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoSheetRowTest {

    @Test
    void exchange() {
        assertThat(LottoSheetRow.of(1, 2, 3, 4, 5, 6).exchange()).isEqualTo(Lotto.of(Auto.FALSE, 1, 2, 3, 4, 5, 6));
    }
}