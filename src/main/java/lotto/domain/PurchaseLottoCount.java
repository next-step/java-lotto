package lotto.domain;

import java.util.Objects;

public class PurchaseLottoCount {

    private static final String MIN_PURCHASE_LOTTO_COUNT = "1개 이상 구매할 수 있습니다. 구매 갯수 : %d";
    private static final String MIN_LOTTO_PRICE = "로또 최소 금액은 0 이상입니다. 입력된 로또 최소 금액 : %d";

    private final int amount;

    public PurchaseLottoCount(PurchaseAmount purchaseAmount, int lottoPrice) {
        this(purchaseAmount.getPurchaseAmount(), lottoPrice);
    }

    public PurchaseLottoCount(int purchaseAmount, int lottoPrice) {
        if (lottoPrice <= 0) {
            throw new IllegalArgumentException(String.format(MIN_LOTTO_PRICE, lottoPrice));
        }
        this.amount = purchaseAmount / lottoPrice;
        validate();
    }

    private void validate() {
        if (this.amount <= 0) {
            throw new IllegalArgumentException(String.format(MIN_PURCHASE_LOTTO_COUNT, this.amount));
        }
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseLottoCount that = (PurchaseLottoCount) o;
        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
