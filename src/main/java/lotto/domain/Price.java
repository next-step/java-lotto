package lotto.domain;

import java.util.Objects;

public class Price {

    private final int value;

    public Price(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("가격은 음수일 수 없다.");
        }

        this.value = value;
    }

    public Count calcualteTicketCount(Price ticketPrice) {
        return new Count(value / ticketPrice.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Price price = (Price) obj;
        return value == price.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
