package com.seok2.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

class LottoSheetTest {

    LottoSheet lottoSheet = LottoSheet.of(Arrays.asList("1,2,3,4,5,6"));

    @Test
    void next() {
        assertThat(lottoSheet.next()).isEqualTo(LottoSheetRow.of(1,2,3,4,5,6));
    }

    @Test
    void isNotEmpty() {
        assertThat(lottoSheet.isNotEmpty()).isEqualTo(true);
    }

}