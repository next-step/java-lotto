package step2.domain;

import java.util.Objects;

class LottoPrice {
    static final LottoPrice DEFAULT = new LottoPrice(1000);
    private static final long MIN_PRICE = 1_000L;

    private final long price;

    public LottoPrice(final long price) {
        checkPrice(price);
        this.price = price;
    }

    private void checkPrice(final long price) {
        if (price != MIN_PRICE) {
            throw new IllegalArgumentException();
        }
    }

    public long price() {
        return price;
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
