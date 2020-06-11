package step3.domain;

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

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public int getLottoTicketsSize() {
        return lottoTickets.size();
    }

}
