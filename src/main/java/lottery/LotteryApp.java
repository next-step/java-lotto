package lottery;

import lottery.controller.LotteryMachine;
import lottery.domain.LotteryNumberGenerator;
import lottery.domain.LotteryResult;
import lottery.domain.LotteryTicket;
import lottery.domain.LotteryTickets;
import lottery.domain.PurchasePrice;
import lottery.domain.RandomLotteryNumberGenerator;
import lottery.view.InputView;
import lottery.view.ResultView;

public class LotteryApp {

    public static void main(String[] args) {
        final LotteryNumberGenerator lotteryNumberGenerator = RandomLotteryNumberGenerator.create();
        final PurchasePrice purchasePrice = InputView.getPurchasePrice();
        final LotteryMachine lotteryMachine = LotteryMachine.create(purchasePrice, lotteryNumberGenerator);
        final LotteryTickets lotteryTickets = lotteryMachine.generate();

        ResultView.showPurchaseInfo(lotteryTickets);

        final LotteryTicket winningLottery = InputView.getWinningLottery();
        final LotteryResult lotteryResult = LotteryResult.from(purchasePrice, winningLottery, lotteryTickets);

        ResultView.showResult(lotteryResult);
    }
}
