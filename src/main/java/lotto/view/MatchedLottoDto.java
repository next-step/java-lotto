package lotto.view;

import lotto.domain.lotto.LottoTickets;

public class MatchedLottoDto {

    private LottoTickets tickets;

    public LottoTickets getTickets() {
        return tickets;
    }

    public void setTickets(final LottoTickets tickets) {
        this.tickets = tickets;
    }
}
