package lotto.domain;

import lotto.util.IntegerUtils;

import java.math.BigDecimal;
import java.util.Objects;

public class Price {
    private final BigDecimal price;

    private Price(BigDecimal price) {
        this.price = price;
    }

    public static Price of(String numberString) {
        return new Price(new BigDecimal(IntegerUtils.parsePositiveInt(numberString)));
    }

    public int getPrice() {
        return this.price.intValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Objects.equals(price, price1.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
