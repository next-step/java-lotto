package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class RankCount {

    private Map<Rank, Integer> rankCountMap;

    public RankCount(Map<Rank, Integer> rankCountMap) {
        this.rankCountMap = rankCountMap;
    }

    public RankCount(List<Rank> rankList) {
        this.rankCountMap = rankList
                .stream()
                .collect(groupingBy(rank -> rank, summingInt(x -> 1)));
    }

    public Map<Rank, Integer> getRankCountMap() {
        return Collections.unmodifiableMap(rankCountMap);
    }

    public int getTotalWinningAmount() {
        int totalWinningAmount = 0;
        for (Map.Entry<Rank, Integer> entry : rankCountMap.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();

            totalWinningAmount += count * rank.getWinningMoney();
        }
        return totalWinningAmount;
    }

    public String getProfitPercent(int totalPurchaseAmount) {
        int winningAmount = getTotalWinningAmount();
        double ratio = (double) winningAmount / totalPurchaseAmount;
        return String.format("%.2f", ratio);
    }
}
