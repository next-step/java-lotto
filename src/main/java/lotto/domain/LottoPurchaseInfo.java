package lotto.domain;

public class LottoPurchaseInfo {
    private static final int MIN_COUNT = 0;
    private static final String LOTTO_COUNT_ERROR = "로또 갯수는 음수일 수 없습니다.";
    private static final String OVER_TOTAL_LOTTO_COUNT_ERROR = "수동으로 구입하는 로또 갯수가 구입가능한 개수보다 많습니다.";

    private final PurchasePrice purchasePrice;
    private final int manualCount;

    public LottoPurchaseInfo(int money, int manualCount) {
        this(new PurchasePrice(money), manualCount);
    }

    public LottoPurchaseInfo(PurchasePrice purchasePrice, int manualCount) {
        validateRange(manualCount);
        this.purchasePrice = purchasePrice;
        this.manualCount = manualCount;
        validateManualCount(manualCount);
    }

    private void validateRange(final int manualCount) {
        if (manualCount < MIN_COUNT) {
            throw new IllegalArgumentException(LOTTO_COUNT_ERROR);
        }
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getMoney() {
        return purchasePrice.getMoney();
    }

    private void validateManualCount(final int manualCount) {
        if (manualCount > calculateAutoCount()) {
            throw new IllegalArgumentException(OVER_TOTAL_LOTTO_COUNT_ERROR);
        }
    }

    public int calculateAutoCount() {
        return purchasePrice.calculateAutoCount() - manualCount;
    }
}
