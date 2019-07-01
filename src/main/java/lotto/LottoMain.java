package lotto;

import lotto.controller.Simulator;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMain {

    public static final int COUNT_OF_ONE = 1;

    public static void main(String[] args) {
        int investMoney = InputView.inputInvestMoney();
        int countOfManualTickets = InputView.inputCountOfManualTicket();
        int countOfAutomaticTickets = Simulator.getCountOfAutomaticTicket(investMoney, countOfManualTickets);

        OutputView.printInformationForManualInput();
        List<Ticket> manualTickets = new ArrayList<>();
        for (int i = 0; i < countOfManualTickets; i++) {
            List<Integer> manualNumbers = InputView.inputManualNumbers();
            List<Ticket> tickets = Simulator.buyTickets(new ManualTicketGenerator(manualNumbers), COUNT_OF_ONE);
            manualTickets.addAll(tickets);
        }
        List<Ticket> automaticTickets = Simulator.buyTickets(new AutomaticTicketGenerator(), countOfAutomaticTickets);
        List<Ticket> tickets = Stream.concat(manualTickets.stream(), automaticTickets.stream())
                .collect(Collectors.toList());

        OutputView.printNumberOfTickets(countOfManualTickets, countOfAutomaticTickets);
        for (Ticket ticket : tickets) {
            OutputView.printTicket(ticket);
        }

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningTicket winningTicket = Simulator.drawWinningTicket(winningNumbers, bonusNumber);

        Statistics statistics = Simulator.simulate(tickets, winningTicket);
        OutputView.printResult(statistics);

        int purchasePrice = Simulator.getPurchasePrice(investMoney, countOfManualTickets);
        double profitRate = statistics.calculateProfitRate(Money.valueOf(purchasePrice));
        OutputView.printProfitRatio(profitRate);
    }
}
