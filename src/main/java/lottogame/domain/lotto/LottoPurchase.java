package lottogame.domain.lotto;

public class LottoPurchase {
    private final int totalAmount;
    private final int manualCount;
    private final int autoCount;

    public LottoPurchase(int totalAmount, int manualCount) {
        this.totalAmount = totalAmount;
        this.manualCount = manualCount;
        this.autoCount = calculateAutoCount(totalAmount, manualCount);
    }

    private int calculateAutoCount(int totalAmount, int manualCount) {
        int totalCount = totalAmount / LottoGameConstants.LOTTO_PRICE;

        return totalCount - manualCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount() {
        return autoCount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
