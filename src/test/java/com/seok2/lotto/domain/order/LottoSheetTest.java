package com.seok2.lotto.domain.order;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoSheetTest {

    private LottoSheet lottoSheet = LottoSheet.of(Arrays.asList("1,2,3,4,5,6"));

    @Test
    void next() {
        assertThat(lottoSheet.next()).isEqualTo(LottoSheetRow.manual(1,2,3,4,5,6));
    }

    @Test
    void isNotEmpty() {
        assertThat(lottoSheet.isNotEmpty()).isEqualTo(true);
    }

}