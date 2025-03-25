package model;

import java.util.Arrays;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> totalRank;
    private int totalPrice;
    private static final int ZERO_COUNT = 0;

    public LottoResult(Map<Rank, Integer> totalRank) {
        this.totalRank = totalRank;
        this.totalPrice = totalRank.entrySet().stream()
                .mapToInt(rank -> rank.getKey().getWinningPrice() * rank.getValue())
                .sum();
    }

    public int getRankCount(Rank rank) {
        return totalRank.getOrDefault(rank, ZERO_COUNT);
    }

    public int getTotalPrice(){
        return totalPrice;
    }
}
