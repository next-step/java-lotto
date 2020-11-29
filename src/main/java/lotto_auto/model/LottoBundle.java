package lotto_auto.model;

import java.util.Collections;
import java.util.List;


public class LottoBundle {

    private List<LottoTicket> lottoTickets;

    public LottoBundle(List<LottoTicket> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public int getTicketCount() {
        return lottoTickets.size();
    }

    public List<LottoTicket> export() {
        return Collections.unmodifiableList(lottoTickets);
    }

}
