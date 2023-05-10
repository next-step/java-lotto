package lotto.domain;

import java.util.List;

public class Lottos {

    private List<LottoTicket> lottoTickets;

    public Lottos(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottos() {
        return this.lottoTickets;
    }
}
