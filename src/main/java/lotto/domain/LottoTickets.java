package lotto.domain;

import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public Price getTotalPrice() {
        return new Price(tickets.size() * LottoOrder.PRICE_PER_TICKET);
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }
}
