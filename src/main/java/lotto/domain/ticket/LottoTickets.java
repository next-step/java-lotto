package lotto.domain.ticket;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public List<LottoTicket> findAll() {
        return new ArrayList<>(lottoTickets);
    }

    public long count() { return lottoTickets.size(); }
}
