package step2.lotto.model;

import java.util.List;

public class LottoTicketList {

    private final List<LottoTicket> lottoTickets;

    public LottoTicketList(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> value() {
        return lottoTickets;
    }

}
