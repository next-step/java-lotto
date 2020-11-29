package lottery;

import lottery.domain.LotteryGame;
import lottery.domain.LotteryResult;
import lottery.domain.LotteryTicket;
import lottery.view.InputViewLotteryGame;
import lottery.view.ResultViewLotteryGame;

import java.util.List;

public class LotteryGameManager {
    public static void main(String[] args) {
        int purchaseAmount = InputViewLotteryGame.getUserInvestAmount();

        LotteryGame lotteryGame = new LotteryGame(1000,6);
        int numberOfTicketsToBuy = lotteryGame.buyNumberOfLotteryTickets(purchaseAmount);
        ResultViewLotteryGame.displayNumberOfTickets(numberOfTicketsToBuy);

        List<LotteryTicket> purchasedTickets = lotteryGame.buyLotteryTickets(numberOfTicketsToBuy);
        ResultViewLotteryGame.displayPurchasedTickets(purchasedTickets);

        String lotteryWinningNumbers = InputViewLotteryGame.getWinningNumbers();
        LotteryResult lotteryResult = lotteryGame.matchLotteryTickets(lotteryWinningNumbers, purchasedTickets);

        ResultViewLotteryGame.displayLotteryResult(lotteryResult, purchaseAmount);
    }
}
