package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class LotteryController {
    public static void main(String[] args) {
        Store store = new Store(InputView.inputPrice(), InputView.inputManualCount());
        int manualCount = store.lotteryManualCount();
        LotteryTickets lotteryTickets = store.createLotteryNumber(InputView.inputLotteryNumber(manualCount));
        OutputView.printLotteryCount(store);
        OutputView.printLotteryNumber(lotteryTickets);

        WinningLottery winningLottery = new WinningLottery(InputView.inputWinningNumber(), InputView.inputBonusBall());
        RankGroup rankGroup = new RankGroup(lotteryTickets, winningLottery);
        MoneyPrize moneyPrize = new MoneyPrize(rankGroup);
        OutputView.resultWinningMessage();
        OutputView.printWinningPrize(rankGroup);
        OutputView.resultLotteryProfit(moneyPrize, store);
    }
}



