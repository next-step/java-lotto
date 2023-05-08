package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class MyResult {
    private final MyPurchase myPurchase;
    private final Map<Rank, Integer> rankCountMap;
    private int prizeAmount;

    public MyResult(MyPurchase myPurchase) {
        this.myPurchase = myPurchase;
        this.rankCountMap = new HashMap<>();
    }

    public void update(Rank rank) {
        prizeAmount += rank.getPrize();
        rankCountMap.put(rank, rankCountMap.getOrDefault(rank, 0) + 1);
    }

    public double profit() {
        return (prizeAmount + 0.0) / (myPurchase.money());
    }

    public int countRank(Rank rank) {
        return rankCountMap.getOrDefault(rank, 0);
    }
}
