package lotto.domain;

public class PurchaseOption {

    private int manualGenerateCnt;
    private int autoGenerateCnt;

    public PurchaseOption(int totalGenerateCnt, int manualGenerateCnt) {
        this.manualGenerateCnt = manualGenerateCnt;
        this.autoGenerateCnt = totalGenerateCnt - manualGenerateCnt;
    }

    public int getManualGenerateCnt() {
        return manualGenerateCnt;
    }

    public int getAutoGenerateCnt() {
        return autoGenerateCnt;
    }
}
