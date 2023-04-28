package lotto.controller;

import lotto.domain.Lottery;
import lotto.domain.Store;
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

        List<Integer> lotteryResult = store.getLotteryResult(lastWeekWinningNumbers);
        double rateOfReturn = store.getRateOfReturn(lotteryResult);
        OutputView.printLotteryResult(lotteryResult);
        OutputView.printRateOfReturn(rateOfReturn);
    }

    private int getPurchaseAmount() {
        OutputView.printPurchaseAmountInputMessage();
        return InputView.getPurchaseAmount();
    }
}
