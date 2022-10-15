package lotto.domain;

public class LottoInput {
    private final int autoCount;
    private final int manualCount;

    public LottoInput(int autoCount, int manualCount) {
        this.autoCount = autoCount;
        this.manualCount = manualCount;
    }

    public int getAutoCount() {
        return autoCount;
    }

    public int getManualCount() {
        return manualCount;
    }
}
