package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.generator.LottoAutoGenerator;
import lotto.domain.lotto.Answer;
import lotto.domain.lotto.PrizeRatio;
import lotto.domain.lotto.PurchaseAction;
import lotto.domain.lotto.Rank;
import lotto.domain.lotto.Ticket;
import lotto.domain.lotto.Tickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static LottoController lottoController = null;

    private LottoController() {
    }

    public static LottoController getInstance() {
        if (lottoController == null) {
            lottoController = new LottoController();
        }
        return lottoController;
    }

    public void run() {
        PurchaseAction purchaseAction = InputView.getAmount();

        Tickets tickets = purchaseAction.purchase();
        OutputView.printBuyingTickets(purchaseAction.getCount());

        showTickets(tickets);
        showResult(tickets, purchaseAction.getAmount());
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
