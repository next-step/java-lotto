package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoBundle {
    private final List<LottoTicket> tickets;

    public LottoBundle(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public List<LottoTicket> getTickets() {
        return Collections.unmodifiableList(this.tickets);
    }
}
