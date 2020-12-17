package lottery;

import lottery.domain.*;
import lottery.view.InputViewLotteryGame;
import lottery.view.ResultViewLotteryGame;

public class LotteryGameManager {
    public static void main(String[] args) {
        int purchaseAmount = Integer.parseInt(InputViewLotteryGame.getUserInvestAmount());

        LotteryGame lotteryGame = new LotteryGame(1000);
        int numberOfTicketsToBuy = lotteryGame.buyNumberOfLotteryTickets(purchaseAmount);
        ResultViewLotteryGame.displayNumberOfTickets(numberOfTicketsToBuy);

        LotteryTickets purchasedTickets = lotteryGame.buyLotteryTickets(
                numberOfTicketsToBuy,
                new AutoBuyBehavior());

        ResultViewLotteryGame.displayPurchasedTickets(purchasedTickets);

        String lotteryWinningNumbers = InputViewLotteryGame.getWinningNumbers();
        String lotteryBonusNumber = InputViewLotteryGame.getBonusNumber();
        LotteryWinning lotteryWinning = new LotteryWinning(lotteryWinningNumbers, lotteryBonusNumber);
        ResultViewLotteryGame.displayLotteryResult(
                lotteryWinning.getLotteryResult(purchasedTickets),
                purchaseAmount);
    }
}
