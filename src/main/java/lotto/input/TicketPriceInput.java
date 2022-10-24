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

    public TicketPriceInput(int priceInput, int ticketAmt) {
        this.priceInput = priceInput;
        this.ticketAmt = ticketAmt;
    }

    public int getTicketAmt() {
        return ticketAmt;
    }

    public static TicketPriceInput.ClientInputBuilder builder() {
        return new TicketPriceInput.ClientInputBuilder();
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

    public static class ClientInputBuilder {
        private int priceInput;
        private int ticketAmt;

        public ClientInputBuilder() {
        }

        public TicketPriceInput.ClientInputBuilder priceInput(int priceInput){
            this.priceInput = priceInput;
            return this;
        }

        public TicketPriceInput.ClientInputBuilder ticketAmt(int ticketAmt){
            this.ticketAmt = ticketAmt;
            return this;
        }

        public TicketPriceInput build() {
            return new TicketPriceInput(this.priceInput, this.ticketAmt);
        }
    }
}
