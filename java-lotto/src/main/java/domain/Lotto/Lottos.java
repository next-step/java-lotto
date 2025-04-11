package domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<LottoTicket> tickets;
    private final int autoTicketCount;

    public Lottos(List<LottoTicket> manualTickets, List<LottoTicket> autoTickets) {
        this.tickets = new ArrayList<>();
        this.tickets.addAll(manualTickets);
        this.tickets.addAll(autoTickets);
        this.autoTicketCount = autoTickets.size();
    }

    public List<LottoTicket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public int getAutoTicketCount() {
        return autoTicketCount;
    }
}
