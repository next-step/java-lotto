package domain;

import java.util.Objects;

public class LottoPrice {
    
    public static final int LOTTO_PRICE = 1000;

    public static int purchaseLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPrice that = (LottoPrice) o;
        return LOTTO_PRICE == that.LOTTO_PRICE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(LOTTO_PRICE);
    }

}
