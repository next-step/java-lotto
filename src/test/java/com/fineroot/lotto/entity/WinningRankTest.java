package com.fineroot.lotto.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningRankTest {

    @Test
    @DisplayName("WinningPolicy of")
    void of() {
        assertThat(WinningRank.of(3)).isEqualTo(WinningRank.FORTH_PRIZE);
    }

    @Test
    void getMatchCount() {
        assertThat(WinningRank.THIRD_PRIZE.getMatchCount()).isEqualTo(4);
    }

    @Test
    void getWinnerPrice() {
        assertThat(WinningRank.FORTH_PRIZE.getWinnerPrice()).isEqualTo(5000);
    }
}