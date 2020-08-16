package lotto.domain;

import java.util.Objects;

class LottoPurchase {
    public static final String ERROR_MESSAGE_CHECK_PURCHASE_AMOUNT = "로또 구매금액은 0보다 커야 합니다.";
    public static final String ERROR_MESSAGE_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 갯수가 알맞지 않습니다.";
    public static final int LOTTO_PRICE = 1_000;
    private static final int ZERO = 0;
    private final long purchaseAmount;
    private final int autoLottoGeneratedCount;
    private final int manualLottoCount;

    LottoPurchase(int purchaseAmount, int autoLottoGeneratedCount, int manualLottoCount) {
        this.purchaseAmount = purchaseAmount;
        this.autoLottoGeneratedCount = autoLottoGeneratedCount;
        this.manualLottoCount = manualLottoCount;
    }

    static LottoPurchase buyAllAuto(int purchaseAmount){
        verifyPurchaseAmount(purchaseAmount);
        return new LottoPurchase(purchaseAmount, purchaseAmount / LOTTO_PRICE, 0);
    }

    static LottoPurchase buyAutoOrManual(int purchaseAmount, int manualLottoCount){
        verifyPurchaseAmount(purchaseAmount);
        final int lottoGeneratedCount = purchaseAmount / LOTTO_PRICE;
        verifyManualLottoCount(manualLottoCount, lottoGeneratedCount);
        return new LottoPurchase(purchaseAmount, lottoGeneratedCount - manualLottoCount, manualLottoCount);
    }

    private static void verifyManualLottoCount(int manualLottoCount, int lottoGeneratedCount) {
        if ( 0 > manualLottoCount || lottoGeneratedCount < manualLottoCount){
            throw new IllegalArgumentException(ERROR_MESSAGE_MANUAL_LOTTO_COUNT);
        }
    }

    private static void verifyPurchaseAmount(int purchaseAmount) {
        if (ZERO >= purchaseAmount) {
            throw new IllegalArgumentException(ERROR_MESSAGE_CHECK_PURCHASE_AMOUNT);
        }
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getAutoLottoGeneratedCount() {
        return autoLottoGeneratedCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoPurchase that = (LottoPurchase) o;
        return purchaseAmount == that.purchaseAmount &&
            autoLottoGeneratedCount == that.autoLottoGeneratedCount &&
            manualLottoCount == that.manualLottoCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseAmount, autoLottoGeneratedCount, manualLottoCount);
    }
}
