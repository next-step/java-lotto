package lottery;

import lottery.domain.*;
import lottery.view.InputView;
import lottery.view.ResultView;

public class Main {

    public static void main(String[] args) {
        PurchasePrice purchasePrice = PurchasePrice.from(InputView.getInputPurchasePrice());
        LotteryStore lotteryStore = LotteryStore.getInstance();
        LotteryTicketsGroup lotteryTicketsGroup = lotteryStore.publishLotteryTicketsGroup(purchasePrice);

        ResultView.printLotteryGameInformation(purchasePrice, lotteryTicketsGroup);

        LotteryTicket lastWinnerTicket = LotteryTicket.from(InputView.getLastWinnerTicketNumbers());
        LotteryGame lotteryGame = LotteryGame.getInstance();
        LotteryGameResult lotteryGameResult = lotteryGame.drawLottery(lotteryTicketsGroup, lastWinnerTicket);
        RateOfReturn rateOfReturn = lotteryGameResult.calculateRateOfReturn(purchasePrice);

        ResultView.printLotteryGameResult(lotteryGameResult);
        ResultView.printRateOfReturn(rateOfReturn);
    }
}
