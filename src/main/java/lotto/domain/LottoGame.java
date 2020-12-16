package lotto.domain;

import lotto.domain.numbers.LottoTickets;
import lotto.domain.numbers.WinningLottoTicket;

public class LottoGame {
    private final LottoTickets lottoTickets;

    public LottoGame(final LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoResult matchNumbers(final WinningLottoTicket winningLottoTicket) {
        return lottoTickets.getMatchLottoResult(winningLottoTicket);
    }
}
