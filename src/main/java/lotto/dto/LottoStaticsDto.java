package lotto.dto;

import java.util.Map;

public class LottoStaticsDto {

    private Map<Integer, Integer> matchingCounts;
    private Map<Integer, Integer> matchingPrices;
    private Double grossRateOfEarnings;

    public LottoStaticsDto(Map<Integer, Integer> matchingCounts,
                           Map<Integer, Integer> matchingPrices,
                           Double grossRateOfEarnings) {
        this.matchingCounts = matchingCounts;
        this.matchingPrices = matchingPrices;
        this.grossRateOfEarnings = grossRateOfEarnings;
    }

    public Map<Integer, Integer> getMatchingCounts() {
        return matchingCounts;
    }

    public Map<Integer, Integer> getMatchingPrices() {
        return matchingPrices;
    }

    public Double getGrossRateOfEarnings() {
        return grossRateOfEarnings;
    }
}
