package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public LottoTickets sum(LottoTickets lottoTickets) {
        this.lottoTickets.addAll(lottoTickets.getLottoTickets());
        return new LottoTickets(this.lottoTickets);
    }

}
