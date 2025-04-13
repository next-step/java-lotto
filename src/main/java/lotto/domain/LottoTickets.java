package lotto.domain;

import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public Price getTotalPrice() {
        return Price.calculateFromTicketCount(tickets.size());
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }
}
