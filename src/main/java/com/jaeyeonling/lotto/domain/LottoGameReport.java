package com.jaeyeonling.lotto.domain;

import java.util.Map;

public class LottoGameReport {

    private static final int DEFAULT_MATCH_COUNT = 0;

    private final Map<LottoPrize, Integer> matchCountByLottoPrize;

    public LottoGameReport(final Map<LottoPrize, Integer> matchCountByLottoPrize) {
        this.matchCountByLottoPrize = matchCountByLottoPrize;
    }

    public Money getTotalPrizeMoney() {
        return new Money(getTotalPrizeMoneyValue());
    }

    public int getMatchCount(final LottoPrize prize) {
        return matchCountByLottoPrize.getOrDefault(prize, DEFAULT_MATCH_COUNT);
    }

    public double getReturnOnInvestment() {
        return getTotalPrizeMoneyValue() / getBuyingMoney();
    }

    private long getTotalPrizeMoneyValue() {
        return matchCountByLottoPrize.keySet()
                .stream()
                .mapToLong(this::getPrizeMoney)
                .sum();
    }

    private long getPrizeMoney(final LottoPrize prize) {
        return getMatchCount(prize) * prize.getPrizeMoney();
    }

    private long getBuyingMoney() {
        return matchCountByLottoPrize.values()
                .stream()
                .mapToLong(this::getPriceOfLotto)
                .sum();
    }

    private long getPriceOfLotto(final int count) {
        return count * Lotto.PRICE_VALUE;
    }
}
