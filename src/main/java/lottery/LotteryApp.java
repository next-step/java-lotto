package lottery;

import lottery.controller.LotteryMachine;
import lottery.domain.LotteryTicket;
import lottery.domain.LotteryTickets;
import lottery.domain.PurchasePrice;
import lottery.dto.LotteryResultDto;
import lottery.view.InputView;
import lottery.view.ResultView;

public class LotteryApp {

    public static void main(String[] args) {
        final PurchasePrice purchasePrice = InputView.getPurchasePrice();
        final LotteryMachine lotteryMachine = LotteryMachine.create(purchasePrice);
        final LotteryTickets tickets = lotteryMachine.tickets();
        ResultView.showPurchaseInfo(tickets);

        final LotteryTicket winningLottery = InputView.getWinningLottery();
        final LotteryResultDto result = lotteryMachine.result(winningLottery);

        ResultView.showResult(result);
    }
}
