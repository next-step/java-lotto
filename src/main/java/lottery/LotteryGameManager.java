package lottery;

import lottery.domain.AutoBuyBehavior;
import lottery.domain.LotteryGame;
import lottery.domain.LotteryResult;
import lottery.domain.LotteryTicket;
import lottery.view.InputViewLotteryGame;
import lottery.view.ResultViewLotteryGame;

import java.util.List;

public class LotteryGameManager {
    public static void main(String[] args) {
        String purchaseAmount = InputViewLotteryGame.getUserInvestAmount();

        LotteryGame lotteryGame = new LotteryGame(1000,6);
        int numberOfTicketsToBuy = lotteryGame.buyNumberOfLotteryTickets(Integer.parseInt(purchaseAmount));
        ResultViewLotteryGame.displayNumberOfTickets(numberOfTicketsToBuy);

        List<LotteryTicket> purchasedTickets = lotteryGame.buyLotteryTickets(
                numberOfTicketsToBuy,
                new AutoBuyBehavior());
        ResultViewLotteryGame.displayPurchasedTickets(purchasedTickets);

        String lotteryWinningNumbers = InputViewLotteryGame.getWinningNumbers();
        LotteryResult lotteryResult = lotteryGame.matchLotteryTickets(lotteryWinningNumbers, purchasedTickets);

        ResultViewLotteryGame.displayLotteryResult(lotteryResult, Integer.parseInt(purchaseAmount));
    }
}
