package com.jaeyeonling.lotto.domain;

import org.junit.jupiter.api.DisplayName;
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
    void should_return_matchCount(final int matchCount) {
        // given
        final LottoPrize prize = LottoPrize.JACKPOT;
        final Map<LottoPrize, Integer> matchCountByRank = new HashMap<>();
        matchCountByRank.put(prize, matchCount);

        final LottoGameReport lottoGameReport = new LottoGameReport(matchCountByRank);

        // when
        final int target = lottoGameReport.getMatchCount(prize);

        // then
        assertThat(target).isEqualTo(matchCount);
    }

    @DisplayName("당첨 별 상금 반환")
    @ParameterizedTest
    @ValueSource(ints = {
            1,
            2,
            100,
            5000
    })
    void should_return_totalPrizeMoney(final int matchCount) {
        // given
        final LottoPrize prize = LottoPrize.JACKPOT;
        final Map<LottoPrize, Integer> matchCountByRank = new HashMap<>();
        matchCountByRank.put(prize, matchCount);

        final LottoGameReport lottoGameReport = new LottoGameReport(matchCountByRank);

        // when
        final Money totalPrizeMoney = lottoGameReport.getTotalPrizeMoney(LottoPrize.JACKPOT);

        // then
        assertThat(totalPrizeMoney).isEqualTo(new Money(prize.getPrizeMoney() * matchCount));
    }

}
