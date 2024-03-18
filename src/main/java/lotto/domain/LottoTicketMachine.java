package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketMachine {

    private static final int AMOUNT_PER_TICKET = 1000;

    public static LottoTickets issue(int amount) {
        List<LottoTicket> tickets = new ArrayList<>();

        int countOfTickets = amount / AMOUNT_PER_TICKET;
        while (countOfTickets-- > 0) {
            tickets.add(new LottoTicket(LottoNumberGenerator.generate()));
        }

        return new LottoTickets(tickets);
    }
}
