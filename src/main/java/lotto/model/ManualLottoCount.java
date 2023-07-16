package lotto.model;

public class ManualLottoCount {
    private static final int ZERO = 0;
    private final int manualCount;

    public ManualLottoCount(final int manualCount) {
        validateManualLottoCount(manualCount);
        this.manualCount = manualCount;
    }

    private static void validateManualLottoCount(final int manualCount) {
        if (manualCount < ZERO) {
            throw new IllegalArgumentException("수동으로 구매할 수 있는 개수는 양수여야합니다.");
        }
    }

    public int getManualCount() {
        return manualCount;
    }
}

