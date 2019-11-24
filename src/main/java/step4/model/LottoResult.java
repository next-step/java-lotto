package step4.model;

import java.util.List;

public class LottoResult {
    private final List<Rank> ranks;
    private final Money money;
    private Money prizeSum;

    public LottoResult(List<Rank> ranks, Money money) {
        this.ranks = ranks;
        this.money = money;

        for (Rank rank : ranks) {
            prizeSum = prizeSum == null ? rank.getPrize() : prizeSum.sum(rank.getPrize());
        }
    }

    public boolean comparePrizeSum(Money money) {
        return prizeSum.equals(money);
    }

    public double getProfit() {
        return money.getProfit(prizeSum);
    }

    public int getRankCount(Rank findRank) {
        return (int) ranks.stream()
                .filter(rank -> rank == findRank)
                .count();
    }
}
