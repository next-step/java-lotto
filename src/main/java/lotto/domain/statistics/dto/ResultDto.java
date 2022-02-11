package lotto.domain.statistics.dto;

import lotto.domain.statistics.vo.RankCounts;

public class ResultDto {

    private final RankCounts rankCounts;
    private final Double prfitRate;

    public ResultDto(RankCounts rankCounts, double profitRate) {
        this.rankCounts = rankCounts;
        this.prfitRate = profitRate;

    }

    public RankCounts getNumberOfRanks() {
        return this.rankCounts;
    }

    public Double getProfitRate() {
        return prfitRate;
    }
}
