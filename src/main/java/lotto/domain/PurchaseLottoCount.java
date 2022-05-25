package lotto.domain;

import java.util.Objects;

public class PurchaseLottoCount {

    private static final String MIN_PURCHASE_LOTTO_COUNT = "1개 이상 구매할 수 있습니다. 구매 갯수 : %d";
    private static final String MIN_LOTTO_PRICE = "로또 최소 금액은 0 이상입니다. 입력된 로또 최소 금액 : %d";
    private static final int ZERO = 0;

    private final int totalAmount;
    private final int manualLottoCount;
    private final int autoLottoCount;

    public PurchaseLottoCount(PurchaseAmount purchaseAmount, int manualLottoCount, int lottoPrice) {
        this(purchaseAmount.getPurchaseAmount(), manualLottoCount, lottoPrice);
    }

    public PurchaseLottoCount(int purchaseAmount, int manualLottoCount, int lottoPrice) {
        validate(purchaseAmount, lottoPrice);
        this.totalAmount = calculateTotalAmount(purchaseAmount, lottoPrice);
        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = totalAmount - manualLottoCount;
    }

    private void validate(int purchaseAmount, int lottoPrice) {
        if (lottoPrice <= ZERO) {
            throw new IllegalArgumentException(String.format(MIN_LOTTO_PRICE, lottoPrice));
        }

        int totalAmount = calculateTotalAmount(purchaseAmount, lottoPrice);
        if (totalAmount <= ZERO) {
            throw new IllegalArgumentException(String.format(MIN_PURCHASE_LOTTO_COUNT, totalAmount));
        }
    }

    private int calculateTotalAmount(int purchaseAmount, int lottoPrice) {
        return purchaseAmount / lottoPrice;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseLottoCount that = (PurchaseLottoCount) o;
        return totalAmount == that.totalAmount && manualLottoCount == that.manualLottoCount && autoLottoCount == that.autoLottoCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalAmount, manualLottoCount, autoLottoCount);
    }
}
