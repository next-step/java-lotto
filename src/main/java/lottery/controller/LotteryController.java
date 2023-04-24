package lottery.controller;

import lottery.domain.*;
import lottery.strategy.ManualTicketIssueStrategy;
import lottery.strategy.RandomTicketIssueStrategy;
import lottery.strategy.TicketIssueStrategy;
import lottery.view.InputView;
import lottery.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LotteryController {
    private final LotteryVendingMachine vendingMachine;

    public LotteryController(LotteryVendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void sell() {
        Scanner scanner = new Scanner(System.in);
        int purchaseMoney = InputView.readPurchaseMoney(scanner);

        int manualNumberOfTicket = InputView.readManualNumberOfTicket(scanner);
        List<LotteryTicket> manualTickets = sellManualTickets(scanner, manualNumberOfTicket);
        purchaseMoney -= manualNumberOfTicket * LotteryTicket.LOTTERY_TICKET_PRICE;

        TicketIssueStrategy randomIssueStrategy = new RandomTicketIssueStrategy();
        List<LotteryTicket> randomTickets = vendingMachine.sellTickets(purchaseMoney, randomIssueStrategy);

        OutputView.printPurchaseCount(manualTickets.size(), randomTickets.size());
        List<LotteryTicket> allTickets = getAllTickets(manualTickets, randomTickets);

        OutputView.printPurchaseTickets(allTickets);

        List<Integer> prizeTicketInts = InputView.readPrizeTicketNumbers(scanner);
        LotteryNumber bonusNumber = new LotteryNumber(InputView.readBonusNumber(scanner));

        LotteryTicket prizeTicketNumbers = LotteryTicket.valueOf(prizeTicketInts);
        LotteryRound lotteryRound = new LotteryRound(prizeTicketNumbers, bonusNumber);
        List<LotteryPrize> lotteryPrizes = lotteryRound.matches(allTickets);

        OutputView.printResultStatistics(lotteryPrizes);
        scanner.close();
    }

    private List<LotteryTicket> sellManualTickets(Scanner scanner, int manualNumberOfTicket) {
        if (manualNumberOfTicket > 0) {
            InputView.printManualTicketNumbers();
        }
        List<LotteryTicket> manualTickets = new ArrayList<>();
        for (int i = 0; i < manualNumberOfTicket; i++) {
            List<Integer> manualTicketNumbers = InputView.readManualTicketNumbers(scanner);
            LotteryTicket manualTicket = vendingMachine.issueTicket(new ManualTicketIssueStrategy(manualTicketNumbers));
            manualTickets.add(manualTicket);
        }
        return manualTickets;
    }

    private List<LotteryTicket> getAllTickets(List<LotteryTicket> manualTickets, List<LotteryTicket> RandomTickets) {
        return new ArrayList<>() {{
            addAll(manualTickets);
            addAll(RandomTickets);
        }};
    }
}
