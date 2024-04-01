package lottery.domain;

import java.util.Collections;
import java.util.List;


public class ManualTickets {

    private final List<LottoTicket> manualTickets;

    public ManualTickets(List<LottoTicket> manualTickets) {
        this.manualTickets = manualTickets;
    }

    public Long ticketCount(){
        return Long.valueOf(this.manualTickets.size());
    }

    public List<LottoTicket> manualTickets() {
        return Collections.unmodifiableList(manualTickets);
    }
}
