package com.nextstep.lotto.lottoGame.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<LottoTicket> tickets;

    public LottoGame(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public static LottoGame byBudget(int budget) {
        int ticketCount = getAvailableTicketCount(budget);
        return new LottoGame(publishAutoTickets(ticketCount));
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

    public List<LottoTicket> getTickets() {
        return this.tickets;
    }

    public int getUsedBudget() {
        return tickets.size() * LottoTicket.LOTTO_TICKET_PRICE;
    }

    public LottoResult result(List<Integer> winningNumbers) {
        return new LottoResult(winningNumbers, tickets);
    }

}
