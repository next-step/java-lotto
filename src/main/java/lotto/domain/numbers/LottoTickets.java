package lotto.domain.numbers;

import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int getCount() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
