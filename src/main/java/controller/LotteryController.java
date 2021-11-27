package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.Set;

public class LotteryController {
    public static void main(String[] args) {
        Store store = new Store(InputView.inputPrice());
        OutputView.purchaseLottery(store);

        LotteryTickets lotteryTickets = store.createLotteryNumber();
        OutputView.printLotteryNumber(lotteryTickets);

        Set<Integer> winningNumber = InputView.inputWinningNumber();
        WinningLottery winningLottery = new WinningLottery(winningNumber, InputView.inputBonusBall());
        RankGroup rankGroup = new RankGroup(lotteryTickets, winningLottery);
        MoneyPrize moneyPrize = new MoneyPrize(rankGroup);
        OutputView.resultWinningMessage();
        OutputView.printWinningPrize(rankGroup);
        OutputView.resultLotteryProfit(moneyPrize, store);
    }
}



