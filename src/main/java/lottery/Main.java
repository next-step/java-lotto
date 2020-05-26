package lottery;

import lottery.domain.LotteryMachine;
import lottery.domain.LotteryTicket;
import lottery.domain.LotteryTicketsGroup;
import lottery.domain.PurchasePrice;
import lottery.view.InputView;
import lottery.view.ResultView;

public class Main {

    public static void main(String[] args) {
        PurchasePrice purchasePrice = new PurchasePrice(InputView.getPurchasePrice());
        LotteryMachine lotteryMachine = new LotteryMachine(purchasePrice);
        ResultView.printLotteryTicketCounts(lotteryMachine);

        LotteryTicketsGroup lotteryTicketsGroup = lotteryMachine.makeLotteryTicketsGroup();
        ResultView.printLotteryTicketsNumbers(lotteryTicketsGroup);

        LotteryTicket lastWinnerTicket = InputView.getLastWinnerTicket();
        LotteryTicketsGroup winnerTicketsGroup = lotteryMachine
                .findWinnerTicketsGroup(lotteryTicketsGroup, lastWinnerTicket);
    }
}
