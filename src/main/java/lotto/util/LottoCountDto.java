package lotto.util;

public class LottoCountDto {
    private int manualCount;
    private int autoCount;

    public LottoCountDto(int manualCount, int autoCount) {
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
