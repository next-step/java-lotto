package lotto.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Price {
    private final BigDecimal price;

    private Price(BigDecimal price) {
        this.price = price;
    }

    public static Price of(String numberString) {
        if (numberString == null || numberString.isEmpty()) {
            throw new NumberFormatException("``price` is must not be null or empty");
        }
        int number;
        try {
            number = Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("``value` is must be number string");
        }
        if (number < 0) {
            throw new NumberFormatException("``value` is must be positive number");
        }
        return new Price(new BigDecimal(number));
    }

    public BigDecimal getPrice() {
        return price;
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
