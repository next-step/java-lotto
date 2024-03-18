package lotto.domain;

import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> get() {
        return this.lottoTickets;
    }

    public int size() {
        return this.lottoTickets.size();
    }
}
