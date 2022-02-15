package lotto.model;

public class Count {

    private final int autoLottoCount;
    private final int manualLottoCount;

    public Count(int autoLottoCount, int manualLottoCount) {

        this.autoLottoCount = autoLottoCount;
        this.manualLottoCount = manualLottoCount;
    }

    public int getCount() {
        return autoLottoCount + manualLottoCount;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }
}
