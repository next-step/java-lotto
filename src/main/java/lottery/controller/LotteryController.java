package lottery.controller;

import lottery.domain.LotteryPrize;
import lottery.domain.LotteryRound;
import lottery.domain.LotteryTicket;
import lottery.domain.LotteryVendingMachine;
import lottery.view.InputView;
import lottery.view.OutputView;

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

        vendingMachine.insertMoney(purchaseMoney);
        List<LotteryTicket> tickets = vendingMachine.sellAvailableTickets();
        OutputView.printPurchaseCount(tickets.size());
        OutputView.printPurchaseTickets(tickets);

        List<Integer> prizeTicketInts = InputView.readPrizeTicketNumbers(scanner);
        LotteryTicket prizeTicketNumbers = LotteryTicket.of(prizeTicketInts);
        LotteryRound lotteryRound = new LotteryRound(prizeTicketNumbers);
        List<LotteryPrize> lotteryPrizes = lotteryRound.matches(tickets);
        
        OutputView.printResultStatistics(lotteryPrizes);
    }
}
