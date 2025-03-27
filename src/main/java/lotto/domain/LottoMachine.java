package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int TICKET_AMOUNT = 1000;

    public List<LottoTicket> issue(int amount) {
        int ticketCount = amount / TICKET_AMOUNT;
        List<LottoTicket> tickets = new ArrayList<>(ticketCount);
        for(int i=0; i<ticketCount; i++) {
            tickets.add(new LottoTicket());
        }
        return tickets;
    }
}
