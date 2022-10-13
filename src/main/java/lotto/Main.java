package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.MatchingResult;
import lotto.domain.WinningNumber;
import lotto.domain.WinningStatistic;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        int purchasePrice = InputView.inputPurchasePrice();

        List<Lotto> lotties = LottoController.buy(purchasePrice);
        ResultView.printLottoNumber(lotties);

        List<Integer> lastWeekAnswer = InputView.lastWeekAnswer();
        int bonusNumber = InputView.bonusNumber();
        List<MatchingResult> matchingResults = LottoController.getMatchingResults(lotties, new WinningNumber(lastWeekAnswer, bonusNumber));

        WinningStatistic winningStatistic = new WinningStatistic(matchingResults);

        ResultView.showResult(winningStatistic, purchasePrice);
    }
}

