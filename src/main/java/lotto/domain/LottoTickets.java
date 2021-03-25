package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> readOnlyLottoTicket() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
