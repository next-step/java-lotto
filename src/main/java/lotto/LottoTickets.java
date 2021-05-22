package lotto;

import java.util.List;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
        System.out.println(lottoTickets);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
