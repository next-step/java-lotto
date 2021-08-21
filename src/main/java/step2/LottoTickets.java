package step2;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private List<Ticket> lottoTickets = new ArrayList<>();

    public void addLottoTicket(Ticket lottoTicket) {
        lottoTickets.add(lottoTicket);
    }

    public List<Ticket> getLottoTickets() {
        return lottoTickets;
    }
}
