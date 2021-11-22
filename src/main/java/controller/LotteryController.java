package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class LotteryController {
    public static void main(String[] args) {
        Store store = new Store(InputView.inputPrice());
        OutputView.purchaseLottery(store);

        LotteryTickets lotteryTickets = store.createLotteryNumber();
        OutputView.printLotteryNumber(lotteryTickets);

        LastWeekLottery lastWeekLottery = new LastWeekLottery(InputView.inputLastWeekNumber());

        RankGroup rankGroup = new RankGroup(lotteryTickets, lastWeekLottery, InputView.inputBonusBall());
        MoneyPrize moneyPrize = new MoneyPrize(rankGroup);
        OutputView.resultWinningMessage();
        OutputView.printWinningPrize(rankGroup);
        OutputView.resultLotteryProfit(moneyPrize, store);
    }
}
