package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int TICKET_PRICE = 1000;

    public List<LottoTicket> issue(int amount) {
        int ticketCount = amount / TICKET_PRICE;
        if(amount < TICKET_PRICE || ticketCount * TICKET_PRICE != amount)
            throw new IllegalArgumentException(String.format("ticket price is %d. check your amount.", TICKET_PRICE));

        List<LottoTicket> tickets = new ArrayList<>(ticketCount);
        for(int i=0; i<ticketCount; i++) {
            tickets.add(new LottoTicket());
        }
        return tickets;
    }
}
