package lottery;

import lottery.domain.*;
import lottery.view.InputViewLotteryGame;
import lottery.view.ResultViewLotteryGame;

import java.util.List;

public class LotteryGameManager {
    public static void main(String[] args) {
        int purchaseAmount = Integer.parseInt(InputViewLotteryGame.getUserInvestAmount());

        LotteryGame lotteryGame = new LotteryGame(1000,6);
        int numberOfTicketsToBuy = lotteryGame.buyNumberOfLotteryTickets(purchaseAmount);
        ResultViewLotteryGame.displayNumberOfTickets(numberOfTicketsToBuy);

        List<LotteryTicket> purchasedTickets = lotteryGame.buyLotteryTickets(
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
