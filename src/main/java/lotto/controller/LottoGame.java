package lotto.controller;

import common.view.LottoInputView;
import common.view.ResultView;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class LottoGame {
    private final LottoTickets lottoTickets;
    private static final LottoMachine lottoMachine = new LottoMachine();

    public LottoGame(int ticketAmount) {
        this.lottoTickets = new LottoTickets(lottoMachine.purchaseLottoTickets(ticketAmount));
    }

    public void playGame() {
        ResultView.showTicketNumber(lottoTickets.getTickets());
        ResultView.printResult(lottoTickets.winningCheck(new LottoTicket(LottoInputView.requestWinningNumbers())));
    }
}
