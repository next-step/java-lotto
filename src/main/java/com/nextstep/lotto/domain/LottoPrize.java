package com.nextstep.lotto.domain;

import java.util.*;

public class LottoPrize {
    private final Map<Rank, Long> result = new LinkedHashMap<>();

    public LottoPrize(final List<Rank> ranks) {
        initDefaultResult();
        updateResult(ranks);
    }

    public Double calculateProfitRate(Money originalMoney) {
        Money totalPrize = sumOfPrizes();

        return totalPrize.divide(originalMoney);
    }

    public Map<Rank, Long> getResult() {
        return result;
    }

    private void initDefaultResult() {
        result.put(Rank.FIFTH, 0L);
        result.put(Rank.FOURTH, 0L);
        result.put(Rank.THIRD, 0L);
        result.put(Rank.SECOND, 0L);
        result.put(Rank.FIRST, 0L);
    }

    private void updateResult(final List<Rank> ranks) {
        ranks.stream().filter(it -> it != Rank.NOTHING)
                .forEach(it -> result.put(it, countRank(it, ranks)));
    }

    private Money sumOfPrizes() {
        Money totalPrize = new Money(0L);

        for (Rank rank : this.result.keySet()) {
            Money totalPrizeOfRank = rank.multiplyPrize(this.result.get(rank));
            totalPrize = totalPrize.plus(totalPrizeOfRank);
        }

        return totalPrize;
    }

    private Long countRank(Rank target, List<Rank> ranks) {
        return ranks.stream()
                .filter(rank -> rank.equals(target))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPrize that = (LottoPrize) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return "LottoPrize{" +
                "result=" + result +
                '}';
    }
}
