package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(int ticketCount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            LottoNumberMaker lottoNumberMaker = new LottoNumberMaker();
            tickets.add(new LottoTicket(lottoNumberMaker.makeNumber()));
        }
        return new LottoTickets(tickets);
    }

    public int getTicketCount() {
        return lottoTickets.size();
    }

    public LottoTicket oneOf(int count) {
        return lottoTickets.get(count);
    }
}
