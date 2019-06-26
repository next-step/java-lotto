package com.java.lotto.domain;

import java.util.List;

public class LottoTickets {
    List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public int amount() {
        return tickets.size();
    }
}
