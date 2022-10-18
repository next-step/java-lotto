package lotto;

import java.util.Objects;

public class ClientInput {

    private static final int DEFAULT_TICKET_PRICE = 1000;

    private final int priceInput;
    private final int ticketAmt;

    public ClientInput(int priceInput, int ticketAmt) {
        this.priceInput = priceInput;
        this.ticketAmt = priceInput / DEFAULT_TICKET_PRICE;
    }

    public int getTicketAmt() {
        return ticketAmt;
    }

    public static ClientInput.ClientInputBuilder builder() {
        return new ClientInput.ClientInputBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientInput that = (ClientInput) o;
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

        public ClientInput.ClientInputBuilder priceInput(int priceInput){
            this.priceInput = priceInput;
            return this;
        }

        public ClientInput.ClientInputBuilder ticketAmt(int ticketAmt){
            this.ticketAmt = ticketAmt;
            return this;
        }

        public ClientInput build() {
            return new ClientInput(this.priceInput, this.ticketAmt);
        }
    }
}
