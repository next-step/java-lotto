package lotto.dto;

import lotto.domain.LottoRank;

import java.util.Map;

public class LottoStatisticsDto {

    private Map<LottoRank, Integer> matchingCounts;
    private Double grossRateOfEarnings;

    public LottoStatisticsDto(Map<LottoRank, Integer> matchingCounts,
                           Double grossRateOfEarnings) {
        this.matchingCounts = matchingCounts;
        this.grossRateOfEarnings = grossRateOfEarnings;
    }

    public Map<LottoRank, Integer> getMatchingCounts() {
        return matchingCounts;
    }

    public Double getGrossRateOfEarnings() {
        return grossRateOfEarnings;
    }
}
