package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.generator.LottoAutoGenerator;
import lotto.domain.lotto.Answer;
import lotto.domain.lotto.Numbers;
import lotto.domain.lotto.PrizeRatio;
import lotto.domain.lotto.Rank;
import lotto.domain.lotto.Ticket;
import lotto.domain.lotto.TicketMachine;
import lotto.domain.lotto.Tickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static LottoController lottoController = null;

    private LottoController() {}

    public static LottoController getInstance() {
        if (lottoController == null) {
            lottoController = new LottoController();
        }
        return lottoController;
    }

    public void run() {
        TicketMachine machine = new TicketMachine(InputView.getAmount(), InputView.getManualLottoTickets());
        Tickets tickets = purchase(machine.manualTickets(), machine.autoTickets());

        showTickets(tickets);
        showResult(tickets, machine.amount());
    }

    private Tickets purchase(final int manualTickets, final int autoTickets) {
        List<Ticket> manualTicketList = purchaseManualTickets(manualTickets);
        List<Ticket> autoTicketList = purchaseAutoTickets(autoTickets);

        OutputView.printBuyingTickets(manualTickets, autoTickets);

        return new Tickets(
            Stream.concat(manualTicketList.stream(), autoTicketList.stream())
                .collect(Collectors.toList())
        );
    }

    private List<Ticket> purchaseManualTickets(final int manualTickets) {
        List<Ticket> tickets = new ArrayList<>();
        List<Numbers> numbers = InputView.getManualLottoNumbers(manualTickets);

        for (Numbers lotto: numbers) {
            tickets.add(new Ticket(lotto));
        }

        return tickets;
    }

    private List<Ticket> purchaseAutoTickets(final int autoTickets) {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < autoTickets; i++) {
            Ticket ticket = new Ticket(new LottoAutoGenerator().generateNumbers());
            tickets.add(ticket);
        }

        return tickets;
    }

    private void showTickets(final Tickets tickets) {
        tickets.getEachTicketNumbers().forEach(OutputView::printLottoTicket);
    }

    private void showResult(final Tickets tickets, final int amount) {
        Answer answer = new Answer(InputView.getComparisonNumbers(), InputView.getBonus());
        Map<Rank, Integer> prizeMap = answer.getComparisonPrizeMap(tickets);

        OutputView.printStatistics(prizeMap);
        OutputView.printResult(new PrizeRatio().calculateRatio(amount, prizeMap));
    }
}