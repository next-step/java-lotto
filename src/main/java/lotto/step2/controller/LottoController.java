package lotto.step2.controller;

import lotto.step2.domain.Lotteries;
import lotto.step2.domain.Lotto;
import lotto.step2.domain.Profit;
import lotto.step2.domain.Store;

import static lotto.step2.view.InputView.printInputOrderPrice;
import static lotto.step2.view.InputView.printInputWinningNumbers;
import static lotto.step2.view.ResultView.*;

public class LottoController {

    public static void main(String[] args) {
        Store store = new Store(printInputOrderPrice());

        printOrderCount(store.getOrderCount());

        Lotteries lotteries = store.getLotteries();
        printOrderLottoNumber(lotteries);

        Lotto winningNumbers = new Lotto(printInputWinningNumbers());

        printWinningStatics(lotteries, winningNumbers);

        Profit profit = new Profit(lotteries, winningNumbers, store.getOrderPrice());
        printRateOfReturn(profit.calculateRateOfProfit());
    }

}
