package lotto.domain.wrapper;

public class LottoPurchaseManualCount {

    private final int count;

    public LottoPurchaseManualCount(int count) {
        this.count = count;
    }

    public int count() {
        return count;
    }
}
