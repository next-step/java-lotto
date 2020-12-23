package lotto.domain;

import lotto.domain.numbers.LottoTickets;
import lotto.domain.numbers.WinningLottoTicket;

public class LottoGame {
    private final LottoTickets manualLottoTickets;
    private final LottoTickets autoLottoTickets;

    public LottoGame(final LottoTickets manualLottoTickets, final LottoTickets autoLottoTickets) {
        this.manualLottoTickets = manualLottoTickets;
        this.autoLottoTickets = autoLottoTickets;
    }

    public LottoResult matchNumbers(final WinningLottoTicket winningLottoTicket) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.update(manualLottoTickets.matchWinningLotto(winningLottoTicket));
        lottoResult.update(autoLottoTickets.matchWinningLotto(winningLottoTicket));
        return lottoResult;
    }
}
