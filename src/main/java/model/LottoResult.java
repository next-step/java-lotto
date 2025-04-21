package model;

import java.util.Map;

public class LottoResult {
    private final int lottoPrice;
    private final Map<Integer, Integer> placementCountsMap;


    public LottoResult(int lottoPrice, Map<Integer, Integer> placementCountsMap) {
        this.lottoPrice = lottoPrice;
        this.placementCountsMap = placementCountsMap;
    }

    public int placementCount(int matchingCount) {
        return placementCountsMap.getOrDefault(matchingCount, 0);
    }

    public int totalPrize() {
        int totalPrize = 0;
        for (Placement placement : Placement.values()) {
            totalPrize += placementCount(placement.matchingCount()) * placement.prizeMoney();
        }
        return totalPrize;
    }

    public int totalInvestment() {
        int totalCount = 0;
        for (Placement placement : Placement.values()) {
            totalCount += placementCount(placement.matchingCount());
        }
        return totalCount * lottoPrice;
    }
}
