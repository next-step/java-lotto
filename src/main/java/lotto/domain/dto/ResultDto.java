package lotto.domain.dto;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import lotto.domain.RankCounts;

public class ResultDto {

    private final Map<String, Integer> matchCount;
    private final Map<String, Integer> amount;
    private final Double prfitRate;

    public ResultDto(RankCounts rankCounts, double profitRate) {
        this.matchCount = new LinkedHashMap<>();
        this.amount = new HashMap<>();
        this.prfitRate = profitRate;

        setRankData(rankCounts);
    }

    private void setRankData(RankCounts rankCounts) {
        rankCounts.get().forEach((rank, count) -> matchCount.put(rank.name(), count));
        rankCounts.get().forEach((rank, count) -> amount.put(rank.name(), rank.getAmount()));
    }

    public Map<String, Integer> getMatchCount() {
        return this.matchCount;
    }

    public Map<String, Integer> getAmounts() {
        return this.amount;
    }

    public Double getProfitRate() {
        return this.prfitRate;
    }
}
