package lottery.controller;

import lottery.domain.*;
import lottery.domain.issue.RandomTicketIssueStrategy;
import lottery.domain.issue.TicketIssueStrategy;
import lottery.view.InputView;
import lottery.view.OutputView;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lottery.domain.LotteryNumber.getAllLotteryNumbers;

public class LotteryController {
    private final Scanner scanner;

    public LotteryController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        int purchaseMoney = InputView.readPurchaseMoney(scanner);
        LotteryVendingMachine vendingMachine = initVendingMachine();
        List<LotteryTicket> tickets = buy(purchaseMoney, vendingMachine);
        result(tickets);
    }

    private LotteryVendingMachine initVendingMachine() {
        TicketIssueStrategy issueStrategy = new RandomTicketIssueStrategy(getAllLotteryNumbers());
        return new LotteryVendingMachine(issueStrategy);
    }

    private List<LotteryTicket> buy(int purchaseMoney, LotteryVendingMachine vendingMachine) {
        vendingMachine.insertMoney(purchaseMoney);
        List<LotteryTicket> tickets = vendingMachine.sellAvailableTickets();
        OutputView.printPurchaseCount(tickets.size());
        OutputView.printPurchaseTickets(tickets);
        return tickets;
    }

    private void result(List<LotteryTicket> tickets) {
        List<Integer> prizeTicketInts = InputView.readPrizeTicketNumbers(scanner);
        List<LotteryNumber> prizeTicketNumbers = prizeTicketInts.stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());

        LotteryRound lotteryRound = new LotteryRound(new LotteryTicket(prizeTicketNumbers));
        List<LotteryPrize> lotteryPrizes = lotteryRound.matches(tickets);

        OutputView.printResultStatistics(lotteryPrizes);
    }
}
