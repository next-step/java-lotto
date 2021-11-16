package lotto.step2.controller;

import lotto.step2.domain.Lotteries;
import lotto.step2.domain.Profit;
import lotto.step2.domain.Statics;
import lotto.step2.domain.Store;

import static lotto.step2.view.InputView.printInputOrderPrice;
import static lotto.step2.view.InputView.printInputWinningNumber;
import static lotto.step2.view.ResultView.*;

public class LottoController {

    public static void main(String[] args) {
        Store store = new Store(printInputOrderPrice());

        printOrderCount(store.getOrderCount());

        Lotteries lotteries = store.getLotteries();
        printOrderLottoNumber(lotteries);

        Statics statics = new Statics(printInputWinningNumber(), lotteries);
        printWinningStatics(statics);

        Profit profit = new Profit(statics, store.getOrderPrice());
        printRateOfReturn(profit.getRateOfProfit());
    }

}
