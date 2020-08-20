package nextstep.lotto.dto;

import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private List<LottoTicket> tickets;

    private LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets create(List<LottoTicket> tickets) {
        return new LottoTickets(tickets);
    }

    public int count(){
        return tickets.size();
    }

    public List<LottoTicket> getAll(){
        return Collections.unmodifiableList(tickets);
    }
}
