package lotto.domain;

public class LottoGame {
    private LottoAnswer answer;
    private LottoTicketBunch ticketBunch;

    public LottoGame(LottoAnswer answer, LottoTicketBunch ticketBunch) {
        this.answer = answer;
        this.ticketBunch = ticketBunch;
    }

    public LottoScoreBoard calcScoreBoard() {
        return ticketBunch.calcScoreBoard(answer);
    }
}
