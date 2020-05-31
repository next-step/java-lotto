package lotto.domain.lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Price {
    public static final int LOTTO_PRICE = 1000;
    private final int DIVIDE_SCALE = 2;

    private final int price;

    public Price(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public int getLottoCount() {
        return this.price / LOTTO_PRICE;
    }

    public BigDecimal calculateProfitRate(final int rankSum) {
        BigDecimal rankSumVale = BigDecimal.valueOf(rankSum);
        BigDecimal priceValue = BigDecimal.valueOf(this.price);

        return rankSumVale.divide(priceValue,DIVIDE_SCALE, RoundingMode.UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        Price price1 = (Price) o;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
