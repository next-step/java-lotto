package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicketBundle {
    private final List<LottoTicket> lottoTickets;

    public LottoTicketBundle(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(this.lottoTickets);
    }
}
