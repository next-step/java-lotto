package lotto.model;

import java.util.Objects;

public class Price implements Comparable<Price> {
    private final int price;

    public Price(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("should be non negative:" + price);
        }
        this.price = price;
    }

    public int value() {
        return this.price;
    }

    public Price minus(Price other) {
        return new Price(this.price - other.price);
    }

    @Override
    public int compareTo(Price o) {
        return Integer.compare(this.price, o.price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
