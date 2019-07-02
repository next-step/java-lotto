package lotto;

import lotto.controller.Simulator;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMain {
    private static final int COUNT_OF_ONE = 1;

    public static void main(String[] args) {
        int investMoney = InputView.inputInvestMoney();
        int countOfManualTickets = InputView.inputCountOfManualTicket();
        int countOfAutomaticTickets = Simulator.getCountOfAutomaticTicket(investMoney, countOfManualTickets);

        OutputView.printInformationForManualInput();
        List<Ticket> tickets = generateTickets(countOfManualTickets, countOfAutomaticTickets);

        OutputView.printNumberOfTickets(countOfManualTickets, countOfAutomaticTickets);
        for (Ticket ticket : tickets) {
            OutputView.printTicket(ticket);
        }

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningTicket winningTicket = Simulator.drawWinningTicket(winningNumbers, bonusNumber);

        Statistics statistics = Simulator.simulate(tickets, winningTicket);
        OutputView.printResult(statistics);

        int purchasePrice = Simulator.getPurchasePrice(investMoney);
        double profitRate = statistics.calculateProfitRate(Money.valueOf(purchasePrice));
        OutputView.printProfitRatio(profitRate);
    }

    private static List<Ticket> generateTickets(int countOfManualTickets, int countOfAutomaticTickets) {
        List<Ticket> manualTickets = generateManualTickets(countOfManualTickets);
        List<Ticket> automaticTickets = generateAutomaticTickets(countOfAutomaticTickets);
        return Stream.concat(manualTickets.stream(), automaticTickets.stream())
                .collect(Collectors.toList());
    }

    private static List<Ticket> generateAutomaticTickets(int countOfAutomaticTickets) {
        return Simulator.buyTickets(new AutomaticTicketGenerator(), countOfAutomaticTickets);
    }

    private static List<Ticket> generateManualTickets(int countOfManualTickets) {
        List<Ticket> manualTickets = new ArrayList<>();
        for (int i = 0; i < countOfManualTickets; i++) {
            List<Integer> manualNumbers = InputView.inputManualNumbers();
            List<Ticket> tickets = Simulator.buyTickets(new ManualTicketGenerator(manualNumbers), COUNT_OF_ONE);
            manualTickets.addAll(tickets);
        }
        return manualTickets;
    }
}
