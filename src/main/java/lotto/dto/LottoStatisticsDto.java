package lotto.dto;

import lotto.domain.LottoRank;

import java.util.HashMap;
import java.util.Map;

public class LottoStatisticsDto {

    private Map<Integer, Integer> matchingCounts;
    private Map<Integer, Integer> matchingPrices;
    private Double grossRateOfEarnings;

    public LottoStatisticsDto(Map<LottoRank, Integer> matchingCounts,
                           Map<LottoRank, Integer> matchingPrices,
                           Double grossRateOfEarnings) {
        this.matchingCounts = toCount(matchingCounts);
        this.matchingPrices = toPrize(matchingPrices);
        this.grossRateOfEarnings = grossRateOfEarnings;
    }

    private Map<Integer, Integer> toCount(Map<LottoRank, Integer> map) {
        Map<Integer, Integer> result = new HashMap<>();
        for (LottoRank lottoRank : map.keySet()) {
            result.put(lottoRank.getMatchCount(), map.get(lottoRank));
        }
        return result;
    }

    private Map<Integer, Integer> toPrize(Map<LottoRank, Integer> map) {
        Map<Integer, Integer> result = new HashMap<>();
        for (LottoRank lottoRank : map.keySet()) {
            result.put(lottoRank.getMatchCount(), lottoRank.getPrizeMoney());
        }
        return result;
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
