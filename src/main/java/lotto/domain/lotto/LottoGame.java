package lotto.domain.lotto;

import lotto.domain.winning.WinningNumbers;

public class LottoGame {

    private final LottoTicket lottoTicket;
    private final WinningNumbers winningNumbers;

    public LottoGame(LottoTicket lottoTicket, WinningNumbers winningNumbers) {
        this.lottoTicket = lottoTicket;
        this.winningNumbers = winningNumbers;
    }

    public void execute() {
        this.lottoTicket.match(this.winningNumbers);
    }
}
