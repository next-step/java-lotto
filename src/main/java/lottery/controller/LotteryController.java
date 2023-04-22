package lottery.controller;

import lottery.domain.*;
import lottery.strategy.TicketIssueStrategy;
import lottery.view.InputView;
import lottery.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class LotteryController {
    private final LotteryVendingMachine vendingMachine;

    public LotteryController(LotteryVendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void sell(TicketIssueStrategy issueStrategy) {
        Scanner scanner = new Scanner(System.in);
        int purchaseMoney = InputView.readPurchaseMoney(scanner);

        List<LotteryTicket> tickets = vendingMachine.sellTickets(purchaseMoney, issueStrategy);
        OutputView.printPurchaseCount(tickets.size());
        OutputView.printPurchaseTickets(tickets);

        List<Integer> prizeTicketInts = InputView.readPrizeTicketNumbers(scanner);
        LotteryNumber bonusNumber = LotteryNumber.valueOf(InputView.readBonusNumber(scanner));

        LotteryTicket prizeTicketNumbers = LotteryTicket.valueOf(prizeTicketInts);
        LotteryRound lotteryRound = new LotteryRound(prizeTicketNumbers, bonusNumber);
        List<LotteryPrize> lotteryPrizes = lotteryRound.matches(tickets);

        OutputView.printResultStatistics(lotteryPrizes);
    }
}
