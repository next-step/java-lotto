package lottery;

import lottery.domain.PurchasePrice;
import lottery.view.InputView;

public class Main {

    public static void main(String[] args) {
        PurchasePrice purchasePrice = PurchasePrice.from(InputView.getInputPurchasePrice());
        /*
        LotteryMachine lotteryMachine = new LotteryMachine(purchasePrice);
        ResultView.printLotteryTicketCounts(lotteryMachine);

        LotteryTicketsGroup lotteryTicketsGroup = lotteryMachine.makeLotteryTicketsGroup();
        ResultView.printLotteryTicketsNumbers(lotteryTicketsGroup);

        LotteryTicket lastWinnerTicket = InputView.getLastWinnerTicket();
        StatisticsBoard statisticsBoard = new StatisticsBoard(lotteryMachine
                .findWinnerTicketCountsByRankMap(lotteryTicketsGroup, lastWinnerTicket));
        RateOfReturn rateOfReturn = new RateOfReturn(statisticsBoard.calculateRateOfReturn(purchasePrice));
        ResultView.printLotteryStatistics(statisticsBoard);
        ResultView.printRateOfReturn(rateOfReturn);
*/
    }
}
