package lotto.domain;

import java.util.List;

public class LottoTicketCollection {

    private final List<LottoTicket> autoTickets;
    private final List<LottoTicket> manualTickets;

    public LottoTicketCollection(List<LottoTicket> autoTickets, List<LottoTicket> manualTickets) {
        this.autoTickets = autoTickets;
        this.manualTickets = manualTickets;
    }

    public List<LottoTicket> getAutoTickets() {
        return autoTickets;
    }

    public List<LottoTicket> getManualTickets() {
        return manualTickets;
    }

    public List<List<LottoTicket>> getAllTicketCollection() {
        return List.of(manualTickets, autoTickets);
    }
}
