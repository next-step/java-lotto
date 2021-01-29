package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private LottoAnswer answer;
    private List<LottoTicket> tickets;

    public LottoGame(LottoAnswer answer, List<LottoTicket> tickets) {
        this.answer = answer;
        this.tickets = tickets;
    }

    public LottoScoreBoard calcScoreBoard() {
        List<LottoScore> scores = new ArrayList<>();
        for (LottoTicket ticket : tickets) {
            scores.add(
                answer.calculateScore(ticket)
            );
        }
        return new LottoScoreBoard(scores);
    }
}
