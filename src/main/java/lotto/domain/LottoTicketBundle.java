package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicketBundle {

    private final List<LottoTicket> autoTickets;
    private final List<LottoTicket> manualTickets;

    public LottoTicketBundle(List<LottoTicket> autoTickets,
        List<LottoTicket> manualTickets) {
        this.autoTickets = autoTickets;
        this.manualTickets = manualTickets;
    }

    public List<LottoTicket> getAutoTickets() {
        return autoTickets;
    }

    public List<LottoTicket> getManualTickets() {
        return manualTickets;
    }

    public int getAutoTicketSize() {
        return autoTickets.size();
    }

    public int getManualTicketSize() {
        return manualTickets.size();
    }

    public List<LottoTicket> getAllLottoTickets() {
        return mergeTickets(autoTickets, manualTickets);
    }

    private List<LottoTicket> mergeTickets(List<LottoTicket>... tickets) {
        return Stream.of(tickets)
            .flatMap(e -> e.stream())
            .collect(Collectors.toList());
    }

}
