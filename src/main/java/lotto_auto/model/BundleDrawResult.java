package lotto_auto.model;

import java.util.List;

public class BundleDrawResult {

    private final List<DrawResult> bundleDrawResult;

    public BundleDrawResult(List<DrawResult> bundleDrawResult) {
        this.bundleDrawResult = bundleDrawResult;
    }

    public int getRankLottoCount(int rank) {
        DrawResult drawResultOfRank = DrawResult.valueOfRank(rank);
        return (int) this.bundleDrawResult.stream()
                .filter(drawResult -> drawResult.equals(drawResultOfRank))
                .count();
    }

    public long getTotalMoney() {
        return bundleDrawResult.stream()
                .mapToLong(DrawResult::getMoney)
                .sum();
    }
}
