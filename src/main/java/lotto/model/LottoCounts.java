package lotto.model;

public class LottoCounts {

    private final LottoCount autoLottoCount;
    private final LottoCount manualLottoCount;

    public LottoCounts(final int totalLottoCount, final int manualLottoCount) {
        this.autoLottoCount = new LottoCount(totalLottoCount - manualLottoCount);
        this.manualLottoCount = new LottoCount(manualLottoCount);
    }

    public int getAutoLottoCount() {
        return autoLottoCount.getCount();
    }

    public int getManualLottoCount() {
        return manualLottoCount.getCount();
    }
}
