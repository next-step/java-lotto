package step3.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> rankMap;
    private final double profitRatio;

    public LottoResult(List<Rank> rankList) {
        this.rankMap = calculateRankMap(rankList);
        this.profitRatio = calculateProfitRatio(rankList);
    }

    private Map<Rank, Integer> calculateRankMap(List<Rank> rankList) {
        Map<Rank, Integer> rankMap = new HashMap<>();
        for (Rank rank : rankList) {
            rankMap.put(rank, rankMap.getOrDefault(rank, 0) + 1);
        }
        return rankMap;
    }

    private double calculateProfitRatio(List<Rank> rankList) {
        int totalWinningMoney = rankList.stream()
                .mapToInt(Rank::getWinningMoney)
                .sum();
        return (double) totalWinningMoney / (rankList.size() * LottoMachine.LOTTO_PRICE);
    }

    public int getRankCount(Rank rank) {
        return rankMap.getOrDefault(rank, 0);
    }

    public double getProfitRatio() {
        return this.profitRatio;
    }
}
