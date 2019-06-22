package com.jaeyeonling.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameReportTest {

    @DisplayName("상금 별 당첨 횟수 반환")
    @ParameterizedTest
    @ValueSource(ints = {
            1,
            2,
            100,
            5000
    })
    void should_return_matchCount_by_prize(final int matchCount) {
        // given
        final Map<LottoPrize, Integer> matchCountByRank = new HashMap<>();
        matchCountByRank.put(LottoPrize.JACKPOT, matchCount);

        final LottoGameReport lottoGameReport = new LottoGameReport(matchCountByRank);

        // when
        final int target = lottoGameReport.getMatchCount(LottoPrize.JACKPOT);

        // then
        assertThat(target).isEqualTo(matchCount);
    }

}
