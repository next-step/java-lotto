package step2;

import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets newInstance(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public int getCount() {
        return this.lottoTickets.size();
    }
}
