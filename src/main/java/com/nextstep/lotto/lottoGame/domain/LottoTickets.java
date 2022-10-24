package com.nextstep.lotto.lottoGame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> tickets;

    public LottoTickets(final List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets ofBudget(int budget) {
        int ticketCount = getAvailableTicketCount(budget);
        return new LottoTickets(publishAutoTickets(ticketCount));
    }

    private static List<LottoTicket> publishAutoTickets(int ticketCount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new LottoTicket());
        }
        return tickets;
    }

    private static int getAvailableTicketCount(int budget) {
        return budget / LottoTicket.LOTTO_TICKET_PRICE;
    }

    public int getUsedBudget() {
        return tickets.size() * LottoTicket.LOTTO_TICKET_PRICE;
    }

    public int getSize() {
        return tickets.size();
    }

    public List<LottoTicket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }
}