package lotto.controller;

import java.util.Map;
import lotto.domain.generator.AutoGenerator;
import lotto.domain.lotto.Answer;
import lotto.domain.lotto.PrizeRatio;
import lotto.domain.lotto.Rank;
import lotto.domain.lotto.Ticket;
import lotto.domain.lotto.Tickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final int PRICE_PER_ONE_TICKET = 1000;

    private final int amount;
    private final int countTickets;
    private final Tickets tickets;

    public LottoController(int amount) {
        this.amount = amount;
        this.countTickets = amount / PRICE_PER_ONE_TICKET;
        this.tickets = new Tickets();
    }

    private void purchase() {
        for (int i = 0; i < countTickets; i++) {
            Ticket ticket = new Ticket(new AutoGenerator().generateNumbers());
            tickets.addTicket(ticket);
        }
        OutputView.printBuyingTickets(countTickets);
    }

    private void showTickets() {
        tickets.get().stream()
            .map(Ticket::getLotto)
            .forEach(OutputView::printLottoTicket);
    }

    private void showResult() {
        Answer answer = new Answer(InputView.getComparisonNumbers(), InputView.getBonus());
        Map<Rank, Integer> matchForEachTickets = answer.compare(tickets);

        OutputView.printStat(matchForEachTickets);
        OutputView.printResult(new PrizeRatio().calculateRatio(amount, matchForEachTickets));
    }

    public void run() {
        purchase();
        showTickets();
        showResult();
    }
}