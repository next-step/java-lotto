package com.jaeyeonling.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameReportTest {

    @DisplayName("생성")
    @Test
    void create() {
        final LottoGameReport lottoGameReport = new LottoGameReport();

        assertThat(lottoGameReport).isNotNull();
    }

}
