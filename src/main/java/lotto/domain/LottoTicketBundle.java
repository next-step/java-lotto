package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicketBundle {

    private final AutoLottoTickets autoLottoTickets;
    private final ManualLottoTickets manualLottoTickets;

    public LottoTicketBundle(AutoLottoTickets autoLottoTickets,
        ManualLottoTickets manualLottoTickets) {
        this.autoLottoTickets = autoLottoTickets;
        this.manualLottoTickets = manualLottoTickets;
    }

    public int getAutoTicketCount(){
        return autoLottoTickets.getCount();
    }

    public int getManualTicketCount(){
        return manualLottoTickets.getCount();
    }

    public List<LottoTicket> getAllLottoTickets() {
        return mergeTickets(autoLottoTickets.value(), manualLottoTickets.value());
    }

    private List<LottoTicket> mergeTickets(List<LottoTicket>... tickets) {
        return Stream.of(tickets)
            .flatMap(e -> e.stream())
            .collect(Collectors.toList());
    }
}
