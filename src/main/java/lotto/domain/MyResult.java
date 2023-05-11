package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyResult {
    private final MyPurchase myPurchase;
    private Map<Rank, Integer> rankCountMap;
    private int prizeAmount;

    public MyResult(MyPurchase myPurchase) {
        this.myPurchase = myPurchase;
    }

    public void update(List<Rank> ranks) {
        prizeAmount = updatePrizeAmount(ranks);
        rankCountMap = updateRanksCount(ranks);
    }

    private int updatePrizeAmount(List<Rank> ranks) {
        return ranks.stream()
                .mapToInt(Rank::getPrize)
                .sum();
    }

    private Map<Rank, Integer> updateRanksCount(List<Rank> ranks) {
        Map<Rank,Integer> updatedRanksCount = new HashMap<>();
        for(Rank rank : ranks){
            updatedRanksCount.put(rank, updatedRanksCount.getOrDefault(rank, 0) + 1);
        }
        return updatedRanksCount;
    }

    public double profit() {
        return (prizeAmount + 0.0) / (myPurchase.money());
    }

    public int countRank(Rank rank) {
        return rankCountMap.getOrDefault(rank, 0);
    }
}
