package com.fineroot.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.ValueSource;

class WinningRankTest {

    @Test
    @DisplayName("WinningRank of")
    void of() {
        assertThat(WinningRank.of(3)).isEqualTo(WinningRank.FIFTH_PRIZE);
    }

    @ParameterizedTest
    @DisplayName("WinningRank valueOf 확인 (SECOND_PRIZE 예외)")
    @CsvSource({"3,'FIFTH_PRIZE'","4,'FORTH_PRIZE'","5,'THIRD_PRIZE'","6,'FIRST_PRIZE'"})
    void valueOf_without_SECOND_PRIZE(int matchCount, WinningRank rank) {
        assertThat(WinningRank.valueOf(matchCount,false)).isEqualTo(rank);
    }

    @ParameterizedTest
    @DisplayName("WinningRank valueOf 확인 (SECOND_PRIZE 만)")
    @CsvSource({"5,'SECOND_PRIZE'"})
    void valueOf_only_SECOND_PRIZE(int matchCount, WinningRank rank) {
        assertThat(WinningRank.valueOf(matchCount,true)).isEqualTo(rank);
    }

    @Test
    void getMatchCount() {
        assertThat(WinningRank.FORTH_PRIZE.getMatchCount()).isEqualTo(4);
    }

    @Test
    void getWinnerPrice() {
        assertThat(WinningRank.FIFTH_PRIZE.getWinnerPrice()).isEqualTo(5000);
    }
}