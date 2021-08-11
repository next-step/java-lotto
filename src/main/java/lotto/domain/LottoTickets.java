package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets = new ArrayList<>();

    public int size() {
        return lottoTickets.size();
    }

    public void add(LottoTicket lottoTicket) {
        this.lottoTickets.add(lottoTicket);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
