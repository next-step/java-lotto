package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.view.WinningNumbersParser;

public class LottoController {

    private final LottoMachine lottoMachine;
    private final LottoResultsService lottoResultsService;
    private final InputView inputview;
    private final ResultView resultView;

    public LottoController(LottoMachine lottoMachine, LottoResultsService lottoResultsService, InputView inputview, ResultView resultView) {
        this.lottoMachine = lottoMachine;
        this.lottoResultsService = lottoResultsService;
        this.inputview = inputview;
        this.resultView = resultView;
    }

    public void run() {
        int purchaseAmount = inputview.readPurchaseAmount();
        LottoTickets tickets = lottoMachine.issue(purchaseAmount);
        resultView.printLottoTickets(tickets);
        String input = inputview.readWinningNumbers();
        WinningNumbers winningNumbers = WinningNumbersParser.parse(input);
        int bonusNumber = inputview.readBonusNumber();
        LottoResult lottoResult = lottoResultsService.calculateResult(tickets, winningNumbers, purchaseAmount);
        resultView.printLottoResult(lottoResult);
    }
}
