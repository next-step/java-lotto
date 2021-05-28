package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int lottoTicketCount() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public LottoTickets concat(LottoTickets targetLottoTickets) {

        List<LottoTicket> totalTicket = new ArrayList<>();
        totalTicket.addAll(lottoTickets);
        totalTicket.addAll(targetLottoTickets.getLottoTickets());

        return new LottoTickets(totalTicket);
    }
}
