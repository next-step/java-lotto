package step3.model;

import java.util.List;

public class LottoResult {
    private final List<Rank> ranks;
    private final int money;
    private int prizeSum;

    public LottoResult(List<Rank> ranks, int money) {
        this.ranks = ranks;
        this.money = money;

        for(Rank rank : ranks) {
            prizeSum += rank.getPrize();
        }
    }

    public int getPrizeSum() {
        return prizeSum;
    }

    public double getProfit() {
        return (Math.floor((double) prizeSum / money * 100) / 100.0);
    }

    public int getRankCount(Rank findRank) {
        return (int)ranks.stream()
                .filter(rank -> rank == findRank)
                .count();
    }
}
