package lottery;

import lottery.domain.*;
import lottery.view.InputView;
import lottery.view.ResultView;

public class Main {

    public static void main(String[] args) {
        PurchasePrice purchasePrice =
                PurchasePrice.of(InputView.getInputPurchasePrice(), InputView.getInputManualTicketCounts());
        ManualTicketsNumbers manualTicketsNumbers =
                new ManualTicketsNumbers(InputView.getInputManualTicketsNumbers(purchasePrice));
        LotteryStore lotteryStore = LotteryStore.getInstance();
        LotteryTicketsGroup lotteryTicketsGroup =
                lotteryStore.publishLotteryTicketsGroup(purchasePrice, manualTicketsNumbers);

        ResultView.printLotteryGameInformation(purchasePrice, lotteryTicketsGroup);

        LotteryTicket lastWinnerTicket =
                LotteryTicket.publishManualLotteryTicket(InputView.getInputLastWinnerTicketNumbers());
        BonusBall bonusBall = BonusBall.of(InputView.getInputBonusBallNumber(), lastWinnerTicket);

        LotteryGame lotteryGame = LotteryGame.getInstance();
        LotteryGameResult lotteryGameResult = lotteryGame
                .drawWinnerLotteryTickets(lotteryTicketsGroup, lastWinnerTicket, bonusBall);
        RateOfReturn rateOfReturn = lotteryGameResult.calculateRateOfReturn(purchasePrice);

        ResultView.printLotteryGameResult(lotteryGameResult);
        ResultView.printRateOfReturn(rateOfReturn);
    }
}
