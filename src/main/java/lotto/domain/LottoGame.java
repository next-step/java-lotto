package lotto.domain;

import java.util.Map;

public class LottoGame {
    private LottoTickets tickets;

    public LottoGame(LottoTickets tickets) {
        this.tickets = tickets;
    }

    public LottoTickets getTickets() {
        return tickets;
    }

    public GameResult gameStart(LottoTicket winningTicket) {
        return tickets.match(winningTicket);
    }


}
