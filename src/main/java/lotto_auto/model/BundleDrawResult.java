package lotto_auto.model;

import java.util.List;

public class BundleDrawResult {

    private final List<DrawResult> bundleDrawResult;

    public BundleDrawResult(List<DrawResult> bundleDrawResult) {
        this.bundleDrawResult = bundleDrawResult;
    }

    public int getRankLottoCount(int rank) {
        return (int) this.bundleDrawResult.stream()
                .filter(item -> item.isRank(rank))
                .count();
    }
}
