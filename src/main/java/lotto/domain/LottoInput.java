package lotto.domain;

public class LottoInput {
    private final int initialAmount;
    private final int availableLottoCount;
    private final int manualCount;
    private final int autoCount;

    public LottoInput(int initialAmount, int availableLottoCount, int manualCount, int autoCount) {
        this.initialAmount = initialAmount;
        this.availableLottoCount = availableLottoCount;
        this.manualCount = manualCount;
        this.autoCount = autoCount;
    }

    public int getInitialAmount() {
        return initialAmount;
    }

    public int getAvailableLottoCount() {
        return availableLottoCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount() {
        return autoCount;
    }
}
