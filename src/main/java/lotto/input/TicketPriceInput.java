package lotto.input;

import java.util.Objects;

public class TicketPriceInput {

    public static final int DEFAULT_TICKET_PRICE = 1000;

    private final int priceInput;
    private final int ticketAmt;

    public TicketPriceInput(int priceInput) {
        this.priceInput = priceInput;
        this.ticketAmt = priceInput / DEFAULT_TICKET_PRICE;
    }

    public int getTicketAmt() {
        return ticketAmt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketPriceInput that = (TicketPriceInput) o;
        return priceInput == that.priceInput && ticketAmt == that.ticketAmt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceInput, ticketAmt);
    }

}
