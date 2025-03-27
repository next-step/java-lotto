package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int TICKET_PRICE = 1000;
    private final int paidAmount;

    public LottoMachine(int paidAmount) {
        this.paidAmount = paidAmount;
        int ticketCount = paidAmount / TICKET_PRICE;
        if(paidAmount < TICKET_PRICE || ticketCount * TICKET_PRICE != paidAmount)
            throw new IllegalArgumentException(String.format("ticket price is %d. check your amount.", TICKET_PRICE));
    }

    public List<LottoTicket> issue() {
        int ticketCount = paidAmount / TICKET_PRICE;

        List<LottoTicket> tickets = new ArrayList<>(ticketCount);
        for(int i=0; i<ticketCount; i++) {
            tickets.add(new LottoTicket());
        }
        return tickets;
    }
}
