package com.monds.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankingTest {

    @Test
    @DisplayName("매칭 개수에 대한 로또 순위 반환")
    void testGetLottoRankingByCountOfMatch() {
        // given
        int countOfMatch = 6;
        // when
        LottoRanking ranking = LottoRanking.valueOf(countOfMatch);
        // then
        assertThat(ranking).isEqualTo(LottoRanking.FIRST);
    }
}
