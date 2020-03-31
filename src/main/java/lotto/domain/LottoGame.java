package lotto.domain;

public class LottoGame {
    private final LottoTickets lottoTickets;

    public LottoGame(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoGameResults match(WinningTicket winningTicket) {
        return new LottoGameResults(lottoTickets.checkRank(winningTicket));
    }
}
