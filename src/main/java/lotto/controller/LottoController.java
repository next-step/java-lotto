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
        List<Set<Integer>> numberSets = readManual(manualCount);

        LottoTickets autoTickets = lottoMachine.issueAuto(autoCount);
        LottoTickets manualTickets = lottoMachine.issueManual(numberSets);
        LottoTickets mergedTickets = autoTickets.merge(manualTickets);
        resultView.printLottoTickets(mergedTickets, manualTickets.size());

        String winningNumbersInput = inputview.readWinningNumbers();
        int bonusNumber = inputview.readBonusNumber();
        WinningNumbers winningNumbers = Parser.parseWinningNumbers(winningNumbersInput, bonusNumber);

        LottoResult lottoResult = lottoResultsService.calculateResult(mergedTickets, winningNumbers, purchaseAmount);
        resultView.printLottoResult(lottoResult);
    }

    private List<Set<Integer>> readManual(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Set<Integer>> numberSets = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            String manualNumbersInput = inputview.readManualNumbers();
            Set<Integer> numberSet = Parser.parseNumberSet(manualNumbersInput);
            numberSets.add(numberSet);
        }

        return numberSets;
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
