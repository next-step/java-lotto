package com.jaeyeonling.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("생성")
    @Test
    void create() {
        LottoGame lottoGame = new LottoGame();

        assertThat(lottoGame).isNotNull();
    }
}
