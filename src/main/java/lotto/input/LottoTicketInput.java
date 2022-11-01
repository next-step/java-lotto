package lotto.input;

import java.util.Objects;

public class LottoTicketInput {

    public static final int DEFAULT_TICKET_PRICE = 1000;

    private final int priceInput;
    private final int ticketCount;

    public LottoTicketInput(int priceInput) {
        this.priceInput = priceInput;
        this.ticketCount = priceInput / DEFAULT_TICKET_PRICE;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicketInput that = (LottoTicketInput) o;
        return priceInput == that.priceInput && ticketCount == that.ticketCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceInput, ticketCount);
    }

    public int calculateRandomTicketAmt(int manualTicketAmt){
        return ticketCount - manualTicketAmt;
    }

}
