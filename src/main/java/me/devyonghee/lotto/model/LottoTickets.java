package me.devyonghee.lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class LottoTickets {

    private static final String NULL_TICKETS_ERROR_MESSAGE = "tickets must not be null";

    private final List<LottoTicket> tickets;

    private LottoTickets(List<LottoTicket> tickets) {
        Objects.requireNonNull(tickets, NULL_TICKETS_ERROR_MESSAGE);
        this.tickets = tickets;
    }

    public static LottoTickets from(List<LottoTicket> tickets) {
        return new LottoTickets(tickets);
    }

    public int size() {
        return tickets.size();
    }

    public List<LottoTicket> list() {
        return Collections.unmodifiableList(tickets);
    }
}
