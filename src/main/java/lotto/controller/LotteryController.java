package lotto.controller;

import lotto.Lottery;
import lotto.Store;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LotteryController {

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        Store store = new Store(purchaseAmount);
        int lotteryCount = store.getLotteryCount();
        OutputView.printPurchaseCompletedMessage(lotteryCount);

        List<Lottery> lotteries = store.getLotteries().getLotteries();
        OutputView.printLotteries(lotteries);

        OutputView.printWinningNumberInputMessage();
        List<Integer> lastWeekWinningNumbers = InputView.getLastWeekWinningNumbers();
        double rateOfReturn = 0.35;
        OutputView.printLotteryResult();
        OutputView.printRateOfReturn(rateOfReturn);


    }

    private static int getPurchaseAmount() {
        OutputView.printPurchaseAmountInputMessage();
        return InputView.getPurchaseAmount();
    }
}
