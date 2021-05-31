package lotto.domain;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatics {

    private Map<Rank, Integer> ranks;
    private int totalCount;

    public LottoStatics(List<Rank> ranks) {
        this.ranks = initializeCounts(ranks);
        this.totalCount = ranks.size();
    }

    public Profit getProfit() {
        double total = getTotalPrize();
        int totalCost = Lotto.PRICE *  totalCount;

        return new Profit(total , totalCost);
    }

    private double getTotalPrize() {
        double total = 0;
        for ( Rank rank : ranks.keySet()) {
            total += Rank.prize(rank) * ranks.get(rank);
        }
        return total;
    }

    public int getRankCount(int targetRank) {
        return ranks.get(Rank.of(targetRank));
    }

    public Map<Rank, Integer> rankCounts() {
        Map<Rank, Integer> counts = new HashMap<>(ranks);
        counts.remove(Rank.nothing);
        return counts;
    }

    private Map<Rank, Integer> initializeCounts(List<Rank> ranks) {
        Map<Rank, Integer> rankCounts = initializeRankMap();
        for (Rank rank : ranks) {
            addRankCount(rankCounts, rank);
        }
        return rankCounts;
    }

    private Map<Rank, Integer> initializeRankMap() {
        Map<Rank,Integer> counts = new HashMap<>();
        for ( Rank rank : Rank.values()) {
            counts.put(rank,0);
        }
        return counts;
    }

    private void addRankCount(Map<Rank, Integer> rankCounts, Rank rank) {
        if (rankCounts.containsKey(rank)) {
            rankCounts.computeIfPresent(rank,(r, ov)->ov+1);
        }
    }

}
