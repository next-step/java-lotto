package lotto.model.wrapper;

import java.util.Objects;

public class LottoPrice {

    private final long price;

    private LottoPrice(final long price) {
        if (price < 0) {
            throw new RuntimeException("상금은 0보다 커야 합니다.");
        }
        this.price = price;
    }

    public static LottoPrice of(final long price) {
        return new LottoPrice(price);
    }

    public long getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoPrice)) return false;
        LottoPrice that = (LottoPrice) o;
        return getPrice() == that.getPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrice());
    }
}
