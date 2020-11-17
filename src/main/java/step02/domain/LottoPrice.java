package step02.domain;

import exception.LottoPriceException;

import java.util.Objects;

public class LottoPrice {
    private final int price;

    private LottoPrice(int price) {
        validate(price);
        this.price = price;
    }
    public static LottoPrice of(int price) {
        return new LottoPrice(price);
    }

    private static void validate(int price) {
        if (price < 1) throw new LottoPriceException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPrice that = (LottoPrice) o;
        return price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
