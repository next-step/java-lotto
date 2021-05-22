package lotto;

import java.util.List;

public class Lottos {
    private List<Lotto> lottoTickets;

    public Lottos(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
