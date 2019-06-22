package com.jaeyeonling.lotto.domain;

import java.util.Map;

public class LottoGameReport {

    private final Map<LottoPrize, Integer> matchCountByLottoPrize;

    public LottoGameReport(final Map<LottoPrize, Integer> matchCountByLottoPrize) {
        this.matchCountByLottoPrize = matchCountByLottoPrize;
    }

    public Money getTotalPrizeMoney() {
        final int money = matchCountByLottoPrize.keySet()
                .stream()
                .mapToInt(this::getWinningMoney)
                .sum();

        return new Money(money);
    }

    public int getMatchCount(final LottoPrize prize) {
        return matchCountByLottoPrize.getOrDefault(prize, 0);
    }

    private int getWinningMoney(final LottoPrize prize) {
        return getMatchCount(prize) * prize.getPrizeMoney();
    }
}
