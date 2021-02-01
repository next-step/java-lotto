package lotto.domain;

public class LottoGame {
    private final LottoAnswer answer;
    private final LottoTicketBunch ticketBunch;

    public LottoGame(LottoAnswer answer, LottoTicketBunch ticketBunch) {
        this.answer = answer;
        this.ticketBunch = ticketBunch;
    }

    public LottoScoreBoard calcScoreBoard() {
        return ticketBunch.calcScoreBoard(answer);
    }
}
