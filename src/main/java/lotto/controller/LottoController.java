package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final LottoMachine lottoMachine;
    private final InputView inputview;
    private final ResultView resultView;

    public LottoController(LottoMachine lottoMachine, InputView inputview, ResultView resultView) {
        this.lottoMachine = lottoMachine;
        this.inputview = inputview;
        this.resultView = resultView;
    }

    public void run() {
        int purchaseAmount = inputview.getPurchaseAmount();
        LottoTickets tickets = lottoMachine.issue(purchaseAmount);
        resultView.printLottoTickets(tickets);
        WinningNumbers winningNumbers = inputview.getWinningNumbers();
    }
}
