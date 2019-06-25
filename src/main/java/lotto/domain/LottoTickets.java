package lotto.domain;

import java.util.List;

public class LottoTickets {
    private List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.tickets = lottoTickets;
    }

    public int size() {
        return tickets.size();
    }

    public LottoResult checkWin(LottoTicket winner) {
        LottoResult lottoResult = new LottoResult();

        for (LottoTicket ticket : tickets) {
            lottoResult.add(ticket.correctWith(winner));
        }

        return lottoResult;
    }
}