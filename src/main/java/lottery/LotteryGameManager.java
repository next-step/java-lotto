package lottery;

import lottery.domain.*;
import lottery.view.InputViewLotteryGame;
import lottery.view.ResultViewLotteryGame;

public class LotteryGameManager {
    public static void main(String[] args) {
        LotteryGame lotteryGame = new LotteryGame(Integer.parseInt(InputViewLotteryGame.getUserInvestAmount()));
        ResultViewLotteryGame.displayNumberOfTickets(lotteryGame.buyNumberOfLotteryTickets());

        lotteryGame.buyLotteryTickets(new AutoBuyBehavior());
        ResultViewLotteryGame.displayPurchasedTickets(lotteryGame.getLotteryTickets());

        lotteryGame.createLotteryWiningTicket(
                InputViewLotteryGame.getWinningNumbers(),
                InputViewLotteryGame.getBonusNumber());

        ResultViewLotteryGame.displayLotteryResult(
                lotteryGame.getLotteryResult(),
                lotteryGame.getLotteryAmount());
    }
}
