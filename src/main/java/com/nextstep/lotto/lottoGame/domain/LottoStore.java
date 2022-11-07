package com.nextstep.lotto.lottoGame.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private LottoStore() {
    }

    public static LottoTickets buyTicketsWithManual(final int budget, final List<LottoTicket> manualTickets) {
        LottoStore.checkBudget(budget, manualTickets.size());
        int autoTicketCount = getAvailableTicketCount(budget) - manualTickets.size();
        List<LottoTicket> tickets = publishAutoTickets(autoTicketCount);
        tickets.addAll(manualTickets);
        return new LottoTickets(tickets);
    }

    public static void checkBudget(final int budget, final int ticketCount) {
        if (getAvailableTicketCount(budget) < ticketCount) {
            throw new IllegalArgumentException("예산이 부족합니다");
        }
    }

    private static List<LottoTicket> publishAutoTickets(final int ticketCount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new LottoTicket());
        }
        return tickets;
    }

    private static int getAvailableTicketCount(final int budget) {
        return budget / LottoTicket.LOTTO_TICKET_PRICE;
    }

}
