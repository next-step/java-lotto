package lottery;

import lottery.domain.LotteryStore;
import lottery.domain.LotteryTicketsGroup;
import lottery.domain.PurchasePrice;
import lottery.view.InputView;
import lottery.view.ResultView;

public class Main {

    public static void main(String[] args) {
        PurchasePrice purchasePrice = PurchasePrice.from(InputView.getInputPurchasePrice());
        LotteryStore lotteryStore = LotteryStore.getInstance();
        LotteryTicketsGroup lotteryTicketsGroup = lotteryStore.publishLotteryTicketsGroup(purchasePrice);

        ResultView.printLotteryGameInformation(purchasePrice, lotteryTicketsGroup);

        //LotteryTicket lastWinnerTicket =
        /*

        LotteryTicket lastWinnerTicket = InputView.getLastWinnerTicket();
        StatisticsBoard statisticsBoard = new StatisticsBoard(lotteryMachine
                .findWinnerTicketCountsByRankMap(lotteryTicketsGroup, lastWinnerTicket));
        RateOfReturn rateOfReturn = new RateOfReturn(statisticsBoard.calculateRateOfReturn(purchasePrice));
        ResultView.printLotteryStatistics(statisticsBoard);
        ResultView.printRateOfReturn(rateOfReturn);
*/
    }
}
