package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.view.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoController {

    private static final int TICKET_PRICE = 1000;

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
        int manualCount = inputview.readNumberOfManuallyPickedTickets();
        LottoPurchase purchase = LottoPurchase.purchase(purchaseAmount, manualCount);
        List<Set<LottoNumber>> numberSets = inputview.readManualNumberSets(purchase.getManualPurchaseCount());

        LottoTickets autoTickets = lottoMachine.issueAuto(purchase.getAutoPurchaseCount());
        LottoTickets manualTickets = lottoMachine.issueManual(numberSets);
        LottoTickets mergedTickets = autoTickets.merge(manualTickets);
        resultView.printLottoTickets(mergedTickets, manualTickets.size());

        String winningNumbersInput = inputview.readWinningNumbers();
        LottoNumber bonusNumber = inputview.readBonusNumber();
        WinningNumbers winningNumbers = inputview.parseWinningNumbers(winningNumbersInput, bonusNumber);

        LottoResult lottoResult = lottoResultsService.calculateResult(mergedTickets, winningNumbers, purchaseAmount);
        resultView.printLottoResult(lottoResult);
    }
}
