package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ranks {

    private Map<Rank, Long> rankCountMap;

    public Ranks(LottoScores lottoScores) {
        List<LottoScore> lottoScoresList = lottoScores.getLottoScoresList();
        this.rankCountMap = lottoScoresList.stream().collect(Collectors.groupingBy(LottoScore::getRank, Collectors.counting()
        ));
    }

    public Map<Rank, Long> getRankCountMap() {
        return Collections.unmodifiableMap(rankCountMap);
    }

    public int getTotalWinningAmount() {
        int totalWinningAmount = 0;
        for (Map.Entry<Rank, Long> entry : rankCountMap.entrySet()) {
            Rank rank = entry.getKey();
            Long count = entry.getValue();

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
