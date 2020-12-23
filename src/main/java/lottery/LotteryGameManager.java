package lottery;

import lottery.domain.*;
import lottery.view.InputViewLotteryGame;
import lottery.view.ResultViewLotteryGame;

import java.util.ArrayList;
import java.util.List;

public class LotteryGameManager {
    public static void main(String[] args) {
        int amountOfMoney = Integer.parseInt(InputViewLotteryGame.getUserInvestAmount());
        int numberOfManual = Integer.parseInt(InputViewLotteryGame.getNumberOfLotterysByManual());
        LotteryGame lotteryGame = new LotteryGame(amountOfMoney, numberOfManual);

        ResultViewLotteryGame.displayInputLotteryNumbersByManual();
        List<String> lotteryNumbersByManual = InputViewLotteryGame.getUserLotteryTicketNumbersByManual(numberOfManual);

        ResultViewLotteryGame.displayNumberOfTickets(lotteryGame.getLotteryAmount());
        lotteryGame.buyLotteryTickets(lotteryNumbersByManual);

        ResultViewLotteryGame.displayPurchasedTickets(lotteryGame.getLotteryTickets());

        lotteryGame.createLotteryWiningTicket(
                InputViewLotteryGame.getWinningNumbers(),
                InputViewLotteryGame.getBonusNumber());

        ResultViewLotteryGame.displayLotteryResult(
                lotteryGame.getLotteryResult(),
                lotteryGame.getLotteryAmount());
    }
}
