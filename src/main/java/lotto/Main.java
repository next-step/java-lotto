package lotto;

import lotto.controller.LottoBuyerController;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        int purchasePrice = InputView.inputPurchasePrice();

        LottoBuyer lottoBuyer = new LottoBuyer(new LottoShop());
        LottoBuyerController lottoBuyerController = new LottoBuyerController(lottoBuyer);
        lottoBuyerController.buyLotto(purchasePrice);

        List<Lotto> lotties = lottoBuyerController.getLotties();
        ResultView.printLottoNumber(lotties);

        List<Integer> lastWeekAnswer = InputView.lastWeekAnswer();
        List<MatchingResult> matchingResults = lottoBuyerController.matchingResults(lastWeekAnswer);

        WinningStatistic winningStatistic = new WinningStatistic(matchingResults);
        winningStatistic.calculateIncome();
        ResultView.showResult(winningStatistic, purchasePrice);
    }
}
