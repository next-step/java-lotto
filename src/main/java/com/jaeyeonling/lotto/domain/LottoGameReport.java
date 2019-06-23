package com.jaeyeonling.lotto.domain;

import java.util.Map;

public class LottoGameReport {

    private static final int DEFAULT_MATCH_COUNT = 0;

    private final Map<LottoPrize, Integer> matchCountByLottoPrize;

    public LottoGameReport(final Map<LottoPrize, Integer> matchCountByLottoPrize) {
        this.matchCountByLottoPrize = matchCountByLottoPrize;
    }

    public Money getTotalPrizeMoney() {
        return new Money(calculateTotalPrizeMoneyValue());
    }

    public int getMatchCountByPrize(final LottoPrize prize) {
        return matchCountByLottoPrize.getOrDefault(prize, DEFAULT_MATCH_COUNT);
    }

    public double getReturnOnInvestment() {
        return calculateTotalPrizeMoneyValue() / calculateBuyingMoney();
    }

    private long calculateTotalPrizeMoneyValue() {
        return matchCountByLottoPrize.keySet()
                .stream()
                .mapToLong(this::calculatePrizeMoney)
                .sum();
    }

    private long calculatePrizeMoney(final LottoPrize prize) {
        return getMatchCountByPrize(prize) * prize.getPrizeMoney();
    }

    private long calculateBuyingMoney() {
        return matchCountByLottoPrize.values()
                .stream()
                .mapToLong(this::calculatePriceOfLotto)
                .sum();
    }

    private long calculatePriceOfLotto(final int count) {
        return count * Lotto.PRICE_VALUE;
    }
}
