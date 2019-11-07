package com.seok2.lotto.domain;


import static com.seok2.lotto.domain.Lotto.LOTTO_PRICE;

import java.util.List;

public class Ranks {

    private final List<Rank> ranks;

    private Ranks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public static Ranks of(List<Rank> ranks) {
        return new Ranks(ranks);
    }

    public long count(Rank rank) {
        return ranks.stream()
            .filter(rank::equals)
            .count();
    }

    public ReturnOnInvestmentRate calculateReturnOnInvestmentRate() {
        return getTotalReward().calculateReturnOnInvestmentRate(calculatePurchaseAmount());
    }

    private Money calculatePurchaseAmount() {
        return LOTTO_PRICE.multiply(ranks.size());
    }

    private Money getTotalReward() {
        return ranks
            .stream()
            .map(Rank::getReward)
            .reduce(Money::add)
            .orElse(Money.ZERO);
    }
}