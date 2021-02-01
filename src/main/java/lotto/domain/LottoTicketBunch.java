package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketBunch {
    private List<LottoTicket> tickets;

    public LottoTicketBunch(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public LottoScoreBoard calcScoreBoard(LottoAnswer answer) {
        return new LottoScoreBoard(
            tickets.stream().map(
                ticket -> answer.calculateScore(ticket)
            ).collect(
                Collectors.toList()
            )
        );
    }
}
