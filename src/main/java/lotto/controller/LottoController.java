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
        int autoCount = this.calculateAutoCount(purchaseAmount, manualCount);
        List<Set<LottoNumber>> numberSets = inputview.readManualNumberSets(manualCount);

        LottoTickets autoTickets = lottoMachine.issueAuto(autoCount);
        LottoTickets manualTickets = lottoMachine.issueManual(numberSets);
        LottoTickets mergedTickets = autoTickets.merge(manualTickets);
        resultView.printLottoTickets(mergedTickets, manualTickets.size());

        String winningNumbersInput = inputview.readWinningNumbers();
        LottoNumber bonusNumber = inputview.readBonusNumber();
        WinningNumbers winningNumbers = Parser.parseWinningNumbers(winningNumbersInput, bonusNumber);

        LottoResult lottoResult = lottoResultsService.calculateResult(mergedTickets, winningNumbers, purchaseAmount);
        resultView.printLottoResult(lottoResult);
    }

    private int calculateAutoCount(int purchaseAmount, int numberPickedTickets) {

        if (purchaseAmount < TICKET_PRICE) {
            throw new IllegalArgumentException("로또를 구매하기 적절한 금액이 아닙니다: " + purchaseAmount);
        }

        int all = purchaseAmount / TICKET_PRICE;
        int numberAutoCreatedTickets = all - numberPickedTickets;

        if (numberAutoCreatedTickets <= 0) {
            throw new IllegalArgumentException("수동으로 구매할 수 있는 개수를 넘었습니다: " + numberPickedTickets);
        }
        return numberAutoCreatedTickets;
    }
}
