package lotto.dto;

import lotto.exception.NoPurchasePriceException;

import java.util.Objects;

public class Price {
    private static final int LOTTO_PRICE = 1000;

    private int price;

    public Price(final int price) {
        checkAvailablePrice(price);
        this.price = price;
    }

    public int lotteryCount() {
        return price / LOTTO_PRICE;
    }

    private void checkAvailablePrice(final int price) {
        if (price < LOTTO_PRICE) {
            throw new NoPurchasePriceException(price);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Price price1 = (Price) o;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
