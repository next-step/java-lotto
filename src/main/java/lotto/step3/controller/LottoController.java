package lotto.step3.controller;

import lotto.step3.domain.Lotteries;
import lotto.step3.domain.Lotto;
import lotto.step3.domain.Profit;
import lotto.step3.domain.Store;

import static lotto.step3.view.InputView.printInputOrderPrice;
import static lotto.step3.view.InputView.printInputWinningNumbers;
import static lotto.step3.view.ResultView.*;

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
