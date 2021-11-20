package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class LotteryController {
    public static void main(String[] args) {
        Store store = new Store(InputView.inputPrice());
        OutputView.purchaseLottery(store);

        LotteryTickets lotteryTickets = store.lotteryNumbersAutomatically();
        OutputView.printLotteryNumber(lotteryTickets);

        LastWeekLotteryNumber lastWeekLottery = new LastWeekLotteryNumber(InputView.inputLastWeekNumber());
        RankGroup rankGroup = new RankGroup(lotteryTickets, lastWeekLottery);
        MoneyPrize moneyPrize = new MoneyPrize(rankGroup);
        OutputView.resultWinningMessage();
        OutputView.printWinningPrize(rankGroup);
        OutputView.resultLotteryProfit(moneyPrize, store);

    }
}
