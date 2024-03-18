package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketMachine {

    private static final int PRICE_PER_TICKET = 1000;

    public static LottoTickets issue(int price) {
        List<LottoTicket> tickets = new ArrayList<>();

        int countOfTickets = price / PRICE_PER_TICKET;
        while (countOfTickets-- > 0) {
            tickets.add(new LottoTicket(LottoNumberGenerator.generate()));
        }

        return new LottoTickets(tickets);
    }
}
