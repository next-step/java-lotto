package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private LottoAnswer answer;
    private List<LottoTicket> tickets;

    public LottoGame(LottoAnswer answer, List<LottoTicket> tickets) {
        this.answer = answer;
        this.tickets = tickets;
    }

    public LottoScoreBoard calcScoreBoard() {
        return new LottoScoreBoard(
            tickets.stream().map(
                ticket -> answer.calculateScore(ticket)
            ).collect(
                Collectors.toList()
            )
        );
    }
}
