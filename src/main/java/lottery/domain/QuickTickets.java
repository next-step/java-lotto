package lottery.domain;

import java.util.Collections;
import java.util.List;


public class QuickTickets {

    private final List<LottoTicket> quickTickets;

    public QuickTickets(List<LottoTicket> quickTickets) {
        this.quickTickets = quickTickets;
    }

    public Long ticketCount(){
        return Long.valueOf(this.quickTickets.size());
    }

    public List<LottoTicket> quickTickets() {
        return Collections.unmodifiableList(quickTickets);
    }

}
