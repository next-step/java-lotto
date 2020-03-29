package lotto.domain;

import lotto.exception.NegativePriceException;

import java.util.Objects;

public class Price {
    public static final int MIN_PRICE = 0;
    private static final int LOTTO_PRICE = 1000;

    private int price;

    public Price(final int price) {
        checkNegative(price);
        this.price = price;
    }

    private void checkNegative(final int price) {
        if (price < MIN_PRICE) {
            throw new NegativePriceException();
        }
    }

    public boolean isAvailablePrice() {
        return price >= LOTTO_PRICE;
    }

    public int lotteryCount() {
        return price / LOTTO_PRICE;
    }

    public Price calculateWinPrice(final int matchCount) {
        return new Price(price * matchCount);
    }


    public Price sum(final Price winPrice) {
        return new Price(price + winPrice.price);
    }

    public double divide(final Price purchasePrice) {
        return (double)this.price / purchasePrice.price;
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
