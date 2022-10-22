package lotto;

import lotto.controller.LottoController;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        int purchasePrice = InputView.inputPurchasePrice();
        int manualCount = InputView.intputManualCount();
        LottoPurchaseMethod lottoPurchaseMethod = new LottoPurchaseMethod(purchasePrice, manualCount);

        InputView.showManualInputMessage();
        List<Lotto> lotties = LottoMachine.createLotto(lottoPurchaseMethod);

        ResultView.printPurchaseMethodMessage(lottoPurchaseMethod);
        ResultView.printLottoNumber(lotties);

        List<Integer> lastWeekAnswer = InputView.lastWeekAnswer();
        int bonusNumber = InputView.bonusNumber();
        List<MatchingResult> matchingResults = LottoController.getMatchingResults(lotties, new WinningNumber(lastWeekAnswer, bonusNumber));

        WinningStatistic winningStatistic = new WinningStatistic(matchingResults);

        ResultView.showResult(winningStatistic, purchasePrice);
    }
}

