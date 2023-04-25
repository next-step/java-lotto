package lotto;

import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public int getTotalAmount() {
        return LottoTicket.PRICE * tickets.size();
    }
}
