package lotto.domain.model.lotto;

import java.util.Objects;

public class TicketPrice {
    private static final int AMOUNT = 1000;
    private final int price;

    public TicketPrice(final int price) {
        this.price = price;
    }

    public static TicketPrice standard() {
        return new TicketPrice(AMOUNT);
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketPrice that = (TicketPrice) o;
        return price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public String toString() {
        return String.valueOf(price);
    }
} 
