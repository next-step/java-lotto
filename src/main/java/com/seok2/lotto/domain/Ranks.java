package com.seok2.lotto.domain;

import static com.seok2.lotto.domain.Lotto.PRICE;

import java.math.BigDecimal;
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

    public BigDecimal calculateYield() {
        return getTotalReward().percent(calculatePurchaseAmount());
    }

    private Money calculatePurchaseAmount() {
        return PRICE.multiply(ranks.size());
    }

    private Money getTotalReward() {
        return ranks
            .stream()
            .map(Rank::getReward)
            .reduce(Money::add)
            .orElse(Money.ZERO);
    }
}
