package lottery;

import lottery.controller.LotteryMachine;
import lottery.domain.LotteryNumberGenerator;
import lottery.domain.LotteryResult;
import lottery.domain.LotteryTickets;
import lottery.domain.PurchasePrice;
import lottery.domain.RandomLotteryNumberGenerator;
import lottery.domain.WinningLotteryNumbers;
import lottery.view.InputView;
import lottery.view.ResultView;

public class LotteryApp {

    public static void main(String[] args) {
        final LotteryNumberGenerator lotteryNumberGenerator = RandomLotteryNumberGenerator.create();
        final PurchasePrice purchasePrice = InputView.getPurchasePrice();
        final LotteryMachine lotteryMachine = LotteryMachine.create(purchasePrice, lotteryNumberGenerator);
        final LotteryTickets lotteryTickets = lotteryMachine.createLotteryTickets();

        ResultView.showPurchaseInfo(lotteryTickets);

        final WinningLotteryNumbers winningLotteryNumbers = InputView.getWinningLotteryNumbers();
        final LotteryResult lotteryResult = lotteryTickets.result(winningLotteryNumbers);

        ResultView.showResult(lotteryResult);
    }
}
