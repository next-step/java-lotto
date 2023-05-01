package lotto.domain;

import java.util.List;

public class LottoGame {
    private final LottoTickets lottoTickets;
    private final WinningTicket winningTicket;

    public LottoGame(LottoTickets lottoTickets, WinningTicket winningTicket) {
        this.lottoTickets = lottoTickets;
        this.winningTicket = winningTicket;
    }

    public LottoResult getLottoResult() {
        List<LottoPrize> winningPrize = calculateWinningPrize();
        return new LottoResult(winningPrize);
    }

    private List<LottoPrize> calculateWinningPrize() {
        return lottoTickets.calculatePrizes(winningTicket);
    }
}
