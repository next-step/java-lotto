package com.nextstep.lotto.lottoGame.domain;

import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> tickets;

    protected LottoTickets(final List<LottoTicket> tickets) {
        this.tickets = tickets;
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