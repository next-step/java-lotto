package step4.domain;

public class LottoCount {

    private int autoCount;
    private int manualCount;

    public LottoCount(int totalCount, int manualCount) {
        this.autoCount = totalCount-manualCount;
        this.manualCount = manualCount;
    }

    public int getAutoCount() {
        return autoCount;
    }

    public int getManualCount() {
        return manualCount;
    }
}
