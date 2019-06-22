package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.config.Env;

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
        return matchCountByLottoPrize.getOrDefault(prize, Env.DEFAULT_MATCH_COUNT);
    }

    public Money getReturnOnInvestment() {
        return new Money(getWinningMoney() / getBuyingMoney());
    }

    private int getWinningMoney(final LottoPrize prize) {
        return getMatchCount(prize) * prize.getPrizeMoney();
    }

    private double getBuyingMoney() {
        return matchCountByLottoPrize.values()
                .stream()
                .mapToDouble(this::getPriceOfLotto)
                .sum();
    }

    private double getWinningMoney() {
        return matchCountByLottoPrize.keySet()
                .stream()
                .mapToDouble(this::getWinningMoney)
                .sum();
    }

    private double getPriceOfLotto(final int count) {
        return count * Env.PRICE_OF_LOTTO;
    }
}
