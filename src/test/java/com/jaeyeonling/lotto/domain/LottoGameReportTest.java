package com.jaeyeonling.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameReportTest {

    @DisplayName("상금 별 당첨 횟수 반환")
    @Test
    void should_return_matchCount_by_prize() {
        // given
        final int matchCount = 1;
        final Map<LottoPrize, Integer> matchCountByRank = new HashMap<>();
        matchCountByRank.put(LottoPrize.JACKPOT, matchCount);

        final LottoGameReport lottoGameReport = new LottoGameReport(matchCountByRank);

        // when
        final int target = lottoGameReport.getMatchCount(LottoPrize.JACKPOT);

        // then
        assertThat(target).isEqualTo(matchCount);
    }

}
