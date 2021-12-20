package lottery;

import lottery.domain.AutoTicketCount;
import lottery.domain.LotteryNumberGenerator;
import lottery.domain.LotteryResult;
import lottery.domain.LotteryTickets;
import lottery.domain.ManualTicketCount;
import lottery.domain.PurchasePrice;
import lottery.domain.RandomLotteryNumberGenerator;
import lottery.domain.WinningLotteryNumbers;
import lottery.view.InputView;
import lottery.view.ResultView;

public class LotteryApp {

    public static void main(String[] args) {
        final LotteryNumberGenerator lotteryNumberGenerator = RandomLotteryNumberGenerator.create();
        final PurchasePrice purchasePrice = InputView.getPurchasePrice();
        final ManualTicketCount manualTicketCount = InputView.getManualLotteryCount(purchasePrice);
        final AutoTicketCount autoTicketCount = manualTicketCount.autoLotteryCount(purchasePrice);

        final LotteryTickets manualLotteryTickets = InputView.getManualLotteryTickets(manualTicketCount);
        final LotteryTickets autoLotteryTickets = autoTicketCount.buyTickets(lotteryNumberGenerator);
        final LotteryTickets purchasedLotteryTickets = LotteryTickets.create(manualLotteryTickets, autoLotteryTickets);

        ResultView.showPurchaseInfo(manualTicketCount, autoTicketCount, purchasedLotteryTickets);

        final WinningLotteryNumbers winningLotteryNumbers = InputView.getWinningLotteryNumbers();
        final LotteryResult lotteryResult = purchasedLotteryTickets.result(purchasePrice, winningLotteryNumbers);

        ResultView.showResult(lotteryResult);
    }
}
