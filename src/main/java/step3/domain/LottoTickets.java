package step3.domain;

import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTicket;

    public LottoTickets(List<LottoTicket> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public List<LottoTicket> getLottoTicket() {
        return lottoTicket;
    }
}
