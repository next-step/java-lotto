package model;


import java.util.Arrays;

public class LottoResult {
    private final int lottoPrice;
    private final int[] placementCounts;

    public LottoResult(int lottoPrice, int[] placementCounts) {
        this.lottoPrice = lottoPrice;
        this.placementCounts = placementCounts;
    }

    public int placementCount(int matchingCount) {
        return placementCounts[matchingCount];
    }

    public double yield(Placements placements) {
        int totalCount = Arrays.stream(placementCounts).sum();
        int totalPrize = placements.totalPrize(placementCounts);

        return (double) totalPrize / (totalCount * lottoPrice);
    }
}
