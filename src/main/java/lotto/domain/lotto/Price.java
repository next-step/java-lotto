package lotto.domain.lotto;

import java.util.Objects;

public class Price {
    public static final int LOTTO_PRICE = 1000;

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

    public float calculateProfitRate(final int rankSum) {
        return ((float) rankSum / this.price);
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
