package lottery;

import lottery.controller.LotteryController;
import lottery.domain.LotteryVendingMachine;
import lottery.strategy.RandomTicketIssueStrategy;
import lottery.strategy.TicketIssueStrategy;

public class LotteryApplication {
    public static void main(String[] args) {
        TicketIssueStrategy ticketIssueStrategy = new RandomTicketIssueStrategy();
        LotteryVendingMachine vendingMachine = new LotteryVendingMachine();
        LotteryController lotteryController = new LotteryController(vendingMachine);
        lotteryController.sell(ticketIssueStrategy);
    }
}
