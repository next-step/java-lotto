package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.lotto.Amount;
import lotto.domain.lotto.Answer;
import lotto.domain.lotto.Number;
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
        TicketMachine machine = new TicketMachine(new Amount(InputView.getAmount()), InputView.getManualLottoTickets());
        Tickets tickets = machine.purchase(getManualTicketNumbers(machine.manualTickets()));

        OutputView.printBuyingTickets(machine.manualTickets(), machine.autoTickets());

        showTickets(tickets);
        showResult(tickets, machine.amount());
    }

    private List<Ticket> getManualTicketNumbers(final int manualTickets) {
        List<Ticket> ticketList = new ArrayList<>();
        for (List<Integer> numbers: InputView.getManualLottoNumbers(manualTickets)) {
            ticketList.add(new Ticket(numbers.stream()
                .map(Number::new)
                .collect(Collectors.toList())
            ));
        }
        return ticketList;
    }

    private void showTickets(final Tickets tickets) {
        tickets.getEachTicketNumbers().forEach(OutputView::printLottoTicket);
    }

    private void showResult(final Tickets tickets, final Amount amount) {
        Answer answer = new Answer(
            new Ticket(InputView.getComparisonNumbers().stream()
                .map(Number::new)
                .collect(Collectors.toList())
            ),
            new Number(InputView.getBonus())
        );
        Map<Rank, Integer> prizeMap = answer.getComparisonPrizeMap(tickets);

        OutputView.printStatistics(prizeMap);
        OutputView.printResult(new PrizeRatio().calculateRatio(amount, prizeMap));
    }
}