package lotto.domain;

public class LottoPurchaseInfo {
    private static final int MIN_COUNT = 0;
    private static final String LOTTO_COUNT_ERROR = "로또 갯수는 음수일 수 없습니다.";

    private final int manualCount;
    private final int autoCount;

    public LottoPurchaseInfo(int manualCount, int autoCount) {
        validateRange(manualCount, autoCount);
        this.manualCount = manualCount;
        this.autoCount = autoCount;
    }

    private void validateRange(final int manualCount, final int autoCount) {
        if (manualCount < MIN_COUNT || autoCount < MIN_COUNT) {
            throw new IllegalArgumentException(LOTTO_COUNT_ERROR);
        }
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount() {
        return autoCount;
    }
}
