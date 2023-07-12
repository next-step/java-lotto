package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WinningResponse {
    private Map<Rank, Integer> ranks;
    private double profit;

    WinningResponse(Map<Rank, Integer> ranks, double profit) {
        this.ranks = ranks;
        this.profit = profit;
    }

    public static WinningResponse of(WinningResult winningResult, LottoMoney gain) {
        Map<Rank, Integer> ranks = new HashMap<>();
        for (Rank rank : Rank.values()) {
            if (rank == Rank.DEFAULT) continue;
            ranks.put(rank, winningResult.getRankCount(rank));
        }
        return new WinningResponse(ranks, winningResult.calculateProfit(gain));
    }

    public double getProfit() {
        return Math.floor(100 * this.profit) / 100.0;
    }

    public Set<Rank> getRanks() {
        return ranks.keySet();
    }

    public int getCount(Rank rank) {
        return ranks.get(rank);
    }

    
}
