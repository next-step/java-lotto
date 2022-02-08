package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.generator.LottoAutoGenerator;
import lotto.domain.lotto.Answer;
import lotto.domain.lotto.PrizeRatio;
import lotto.domain.lotto.Rank;
import lotto.domain.lotto.Ticket;
import lotto.domain.lotto.Tickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final int PRICE_PER_ONE_TICKET = 1000;

    private static LottoController lottoController = null;

    private LottoController() {}

    public static LottoController getInstance() {
        if (lottoController == null) {
            lottoController = new LottoController();
        }
        return lottoController;
    }

    public void run() {
        Tickets tickets;
        int amount = InputView.getAmount();
        int count = amount / PRICE_PER_ONE_TICKET;

        tickets = purchase(count);
        showTickets(tickets);
        showResult(tickets, amount);
    }

    private Tickets purchase(final int count) {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Ticket ticket = new Ticket(new LottoAutoGenerator().generateNumbers());
            tickets.add(ticket);
        }
        OutputView.printBuyingTickets(count);

        return new Tickets(tickets);
    }

    private void showTickets(final Tickets tickets) {
        tickets.get().stream()
            .map(Ticket::getLotto)
            .forEach(OutputView::printLottoTicket);
    }

    private void showResult(final Tickets tickets, final int amount) {
        Answer answer = new Answer(InputView.getComparisonNumbers(), InputView.getBonus());
        Map<Rank, Integer> prizeMap = answer.compare(tickets);

        OutputView.printStatistics(prizeMap);
        OutputView.printResult(new PrizeRatio().calculateRatio(amount, prizeMap));
    }
}