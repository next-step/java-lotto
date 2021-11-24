package lotto.domain;

import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public int getTicketSize() {
        return tickets.size();
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public int getTotalPrice(int price) {
        return tickets.size() * price;
    }
}
