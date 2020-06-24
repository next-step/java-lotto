package step4.domain.lotto;

import java.util.List;

/*
 * Lotto
 * Lotto Tickets
 * ver. 1.0
 * 2020.06.06.
 */
public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public void add(List<Lotto> lottoTickets) {
        this.lottoTickets.addAll(lottoTickets);
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

}
