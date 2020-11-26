package lotto_auto.model;

import java.util.List;

public class BundleDrawResult {

    private final List<DrawResult> bundleDrawResult;

    public BundleDrawResult(List<DrawResult> bundleDrawResult) {
        this.bundleDrawResult = bundleDrawResult;
    }

    public int getRankLottoCount(int rank) {
        DrawResult drawResult = DrawResult.valueOfRank(rank);
        return (int) this.bundleDrawResult.stream()
                .filter(item -> item.equals(drawResult))
                .count();
    }

    public long getTotalMoney() {
        return bundleDrawResult.stream()
                .mapToLong(DrawResult::getMoney)
                .sum();
    }
}
