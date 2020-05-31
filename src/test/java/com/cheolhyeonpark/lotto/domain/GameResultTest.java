package com.cheolhyeonpark.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class GameResultTest {

    @Test
    void getCount() {
        GameResult gameResult = new GameResult();
        gameResult.count(Rank.FIRST);
        assertThat(gameResult.getCount(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    void getYields() {
        GameResult gameResult = new GameResult();
        gameResult.count(Rank.FIFTH);
        assertThat(gameResult.getYields(10_000)).isEqualTo(0.5);
    }
}