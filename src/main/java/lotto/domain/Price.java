package lotto.domain;

import java.util.Objects;

public class Price {

    private final static int TICKET_PRICE = 1000;
    private final int value;

    public Price(int value) {
        if (value < TICKET_PRICE) {
            throw new IllegalArgumentException("가격은 티켓 가격(" + TICKET_PRICE + "원)보다 작을 수 없다.");
        }

        this.value = value;
    }

    public static Price calculateFromTicketCount(int ticketCount) {
        return new Price(ticketCount * TICKET_PRICE);
    }

    public Count calculateTicketCount() {
        return new Count(value / TICKET_PRICE);
    }

    public double calculateYield(int winningAmount) {
        return (double) winningAmount / value;
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
