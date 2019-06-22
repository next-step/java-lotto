package com.jaeyeonling.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        this.lottoGame = new LottoGame();
    }

    @DisplayName("로또 구매 테스트")
    @Test
    void should_return_lottos_when_buy() {
        final List<Lotto> lottos = lottoGame.buy();

        assertThat(lottos).isNotNull();
    }
}
