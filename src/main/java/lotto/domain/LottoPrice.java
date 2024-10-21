package lotto.domain;

import java.util.Objects;

public class LottoPrice {
    private static final int SINGLE_LOTTO_PRICE = 1000;

    private final int lottoPrice;

    public LottoPrice(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.lottoPrice = purchaseAmount;
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < SINGLE_LOTTO_PRICE) {
            throw new IllegalArgumentException("구입금액은 최소 1000원 이상이어야 합니다.");
        }
    }

    public int countLottoQuantity() {
        return this.lottoPrice / SINGLE_LOTTO_PRICE;
    }

    public float value() {
        return this.lottoPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPrice that = (LottoPrice) o;
        return lottoPrice == that.lottoPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoPrice);
    }
}
