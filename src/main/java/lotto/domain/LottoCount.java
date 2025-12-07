package lotto.domain;

public class LottoCount {
    private final int manualCount;
    private final int autoCount;

    public LottoCount(Money money, int manualCount) {
        this(money.getBuyableCount() - manualCount, manualCount);
    }

    public LottoCount(int autoCount, int manualCount) {
        this.autoCount = autoCount;
        this.manualCount = manualCount;
    }

    public int getManualCount() {
        return this.manualCount;
    }

    public int getAutoCount() {
        return this.autoCount;
    }
}
