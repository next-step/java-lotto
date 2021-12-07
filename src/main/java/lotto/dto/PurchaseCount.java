package lotto.dto;

public class PurchaseCount {
    private final int manualCount;
    private final int autoCount;

    public PurchaseCount(int manualCount, int autoCount) {
        this.manualCount = manualCount;
        this.autoCount = autoCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount() {
        return autoCount;
    }
}
