package step2.domain;

import java.util.Objects;

public class LottoPrice {
    private static final int MIN_PRICE = 1000;

    private final int price;

    public LottoPrice(final int price) {
        checkPrice(price);
        this.price = price;
    }

    private void checkPrice(final int price) {
        if (price != MIN_PRICE) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoPrice)) return false;
        final LottoPrice that = (LottoPrice) o;
        return price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
