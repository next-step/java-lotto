package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int TICKET_AMOUNT = 1000;

    public List<LottoTicket> issue(int amount) {
        List<LottoTicket> tickets = new ArrayList<>();
        if(amount == TICKET_AMOUNT) {
            tickets.add(new LottoTicket());
        }
        return tickets;
    }
}
