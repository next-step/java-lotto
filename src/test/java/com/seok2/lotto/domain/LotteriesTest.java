package com.seok2.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LotteriesTest {

    @Test
    void check() {
        Lotteries lotteries = Lotteries.of(Arrays.asList(Lotto.generate("1,2,3,4,5,6"),Lotto.generate("1,2,3,7,8,9")));
        Ranks ranks = lotteries.check(WinningLotto.of(Lotto.generate("1,2,3,10,11,12"), LottoNumber.of(13)));
        assertThat(ranks.count(Rank.FIFTH)).isEqualTo(2);
    }
}