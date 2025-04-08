package lotto.domain.model;

import java.util.ArrayList;
import java.util.List;


public class MatchResult {
    private final List<Rank> ranks = new ArrayList<>();

    public void addRank(Rank rank) {
        this.ranks.add(rank);
    }

    public int getCount(Rank rank) {
        return (int) this.ranks.stream()
                .filter(r -> r == rank)
                .count();
    }

    public double calculateProfit(int purchaseAmount) {
        return (double) getPrize() / purchaseAmount;
    }

    private int getPrize() {
        int totalPrize = 0;
        for (Rank rank : this.ranks) {
            totalPrize += rank.getWinningMoney();
        }
        return totalPrize;
    }
}
