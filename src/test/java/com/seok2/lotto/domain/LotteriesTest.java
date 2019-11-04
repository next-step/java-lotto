package com.seok2.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LotteriesTest {

    @Test
    void check() {
        Lotteries lotteries = new Lotteries(Arrays.asList(Lotto.generate("1,2,3,4,5,6"),Lotto.generate("1,2,3,7,8,9")));
        GameStats stats = lotteries.check(Lotto.generate("1,2,3,10,11,12"));
        assertThat(stats.getNumberOfWins(Rank.FOURTH)).isEqualTo(2);
    }
}