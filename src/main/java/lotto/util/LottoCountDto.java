package lotto.util;

public class LottoCountDto {
    private int manualCount;
    private int autoCount;

    private LottoCountDto(int manualCount, int autoCount) {
        this.manualCount = manualCount;
        this.autoCount = autoCount;
    }

    public static LottoCountDto of(int manualCount, int autoCount) {
        return new LottoCountDto(manualCount, autoCount);
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount() {
        return autoCount;
    }
}
