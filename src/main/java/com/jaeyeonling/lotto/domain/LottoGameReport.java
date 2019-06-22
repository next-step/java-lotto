package com.jaeyeonling.lotto.domain;

import java.util.Map;

public class LottoGameReport {

    private static final int DEFAULT_MATCH_COUNT = 0;

    private final Map<LottoPrize, Integer> matchCountByLottoPrize;

    public LottoGameReport(final Map<LottoPrize, Integer> matchCountByLottoPrize) {
        this.matchCountByLottoPrize = matchCountByLottoPrize;
    }

    public Money getTotalPrizeMoney() {
        final long money = matchCountByLottoPrize.keySet()
                .stream()
                .mapToLong(this::getWinningMoney)
                .sum();

        return new Money(money);
    }

    public int getMatchCount(final LottoPrize prize) {
        return matchCountByLottoPrize.getOrDefault(prize, DEFAULT_MATCH_COUNT);
    }

    public double getReturnOnInvestment() {
        return getWinningMoney() / getBuyingMoney();
    }

    private long getWinningMoney(final LottoPrize prize) {
        return getMatchCount(prize) * prize.getPrizeMoney();
    }

    private long getBuyingMoney() {
        return matchCountByLottoPrize.values()
                .stream()
                .mapToLong(this::getPriceOfLotto)
                .sum();
    }

    private long getWinningMoney() {
        return matchCountByLottoPrize.keySet()
                .stream()
                .mapToLong(this::getWinningMoney)
                .sum();
    }

    private long getPriceOfLotto(final int count) {
        return count * Lotto.PRICE;
    }
}
