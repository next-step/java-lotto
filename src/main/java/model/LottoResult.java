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

    public double yield() {
        int totalPrize = 0;
        int totalCount = 0;
        for (Placement placement : Placement.values()) {
            totalCount += placementCount(placement.matchingCount());
            totalPrize += placementCount(placement.matchingCount()) * placement.prizeMoney();
        }
        return (double) totalPrize / (totalCount * lottoPrice);
    }
}
