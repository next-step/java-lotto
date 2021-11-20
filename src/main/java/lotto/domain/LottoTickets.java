package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LottoTickets {

    private final Set<LottoTicket> tickets;

    public LottoTickets() {
        this.tickets = new HashSet<>();
    }

    public LottoTickets autoLottoTicket(Integer ticketCount) {
        while (tickets.size() != ticketCount) {
            tickets.add(LottoTicket.of(new ArrayList<>(AutoTicket.ticket())));
        }
        return this;
    }

    public Integer size() {
        return tickets.size();
    }

    public Set<LottoTicket> getTickets() {
        return Collections.unmodifiableSet(tickets);
    }

}
