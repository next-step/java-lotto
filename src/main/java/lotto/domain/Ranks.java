package lotto.domain;

import java.util.EnumMap;
import java.util.List;

public class Ranks {
    private final EnumMap<Rank, Integer> ranks = new EnumMap<>(Rank.class);

    private final int purchaseAmount;

    public Ranks(List<Rank> ranks, int purchaseAmount) {
        init();
        this.purchaseAmount = purchaseAmount;
        for (Rank rank : ranks) {
            this.ranks.put(rank, countRank(rank));
        }
    }

    private void init(){
        for(Rank rank : Rank.values()) {
            this.ranks.put(rank, 0);
        }
    }

    private Integer countRank(Rank rank) {
        return this.ranks.get(rank) + 1;
    }

    public EnumMap<Rank, Integer> getRanks() {
        return ranks;
    }

    public int getTotalWinningAmount() {
        return ranks.entrySet().stream()
                .mapToInt(rankMap -> rankMap.getKey().calculatePrize(rankMap.getValue()))
                .sum();
    }

    public double caculateIncomePercentage(){
        return  getTotalWinningAmount() / (double)purchaseAmount;
    }
}
