package lotto.domain;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatics {

    private List<Rank> ranks;

    public LottoStatics(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public Profit getProfit() {
        double total = getTotalPrize();
        int totalCost = Lotto.PRICE *  ranks.size();

        return new Profit(total , totalCost);
    }

    private double getTotalPrize() {
        double total = 0;
        for ( Rank rank : ranks) {
            total += Rank.prize(rank);
        }
        return total;
    }

    public int getRankCount(int targetRank) {
        int count = 0;
        for (Rank rank : ranks) {
            if( rank == Rank.of(targetRank)) {
                count++;
            }
        }
        return count;
    }

    public Map<Rank, Integer> rankCounts() {
        Map<Rank, Integer> rankCounts = initializeCounts();
        for (Rank rank : this.ranks) {
            addRankCount(rankCounts, rank);
        }
        return rankCounts;
    }

    private Map<Rank, Integer> initializeCounts() {
        Map<Rank, Integer> rankCounts = new HashMap<>();
        Rank[] ranks = Rank.values();
        int start = Rank.threeNumbersMatch.ordinal();

        for (int i = start; i < ranks.length; i++) {
            rankCounts.put(ranks[i],0);
        }
        return rankCounts;
    }

    private void addRankCount(Map<Rank, Integer> rankCounts, Rank rank) {
        if (rankCounts.containsKey(rank)) {
            rankCounts.computeIfPresent(rank,(r, ov)->ov+1);
        }
    }

}
