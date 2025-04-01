package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LottoTickets {

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = new ArrayList<>(tickets);
    }

    public int size() {
        return tickets.size();
    }

    public List<LottoTicket> getAll() {
        return Collections.unmodifiableList(tickets);
    }
}
