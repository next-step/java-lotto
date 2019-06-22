package com.jaeyeonling.lotto.domain;

import java.util.Map;

public class LottoGameReport {

    private final Map<LottoPrize, Integer> matchCountByLottoPrize;

    public LottoGameReport(final Map<LottoPrize, Integer> matchCountByLottoPrize) {
        this.matchCountByLottoPrize = matchCountByLottoPrize;
    }

    public Money getTotalPrizeMoney() {
        return null;
    }

    public int getMatchCount(final LottoPrize prize) {
        return matchCountByLottoPrize.getOrDefault(prize, 0);
    }
}
