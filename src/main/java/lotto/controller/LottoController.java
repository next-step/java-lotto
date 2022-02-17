package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.generator.LottoManualGenerator;
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

    private LottoController() {
    }

    public static LottoController getInstance() {
        if (lottoController == null) {
            lottoController = new LottoController();
        }
        return lottoController;
    }

    public void run() {
        final Amount amount = new Amount(InputView.getAmount());
        final int manualLottoTickets = InputView.getManualLottoTickets();
        final List<Ticket> manualTickets = getManualTickets(manualLottoTickets);

        TicketMachine machine = new TicketMachine(amount, manualTickets);
        Tickets tickets = machine.purchase();

        OutputView.printBuyingTickets(manualTickets.size(), amount.getAutoTickets(manualTickets.size()));

        showTickets(tickets);
        showResult(tickets, amount);
    }

    private void showTickets(final Tickets tickets) {
        OutputView.printLottoTicket(tickets.getEachTicketNumbers());
    }

    private void showResult(final Tickets tickets, final Amount amount) {
        final Ticket answerTicket = getAnswerTicket();
        final Number bonusNumber = new Number(InputView.getBonus());

        Answer answer = new Answer(answerTicket, bonusNumber);
        Map<Rank, Integer> prizeMap = answer.getComparisonPrizeMap(tickets);

        OutputView.printStatistics(prizeMap);
        OutputView.printResult(new PrizeRatio().calculateRatio(amount, prizeMap));
    }

    private List<Ticket> getManualTickets(final int manualTickets) {
        List<Ticket> numbersPerOneLotto = new ArrayList<>();
        for (List<Integer> numbers : InputView.getManualLottoNumbers(manualTickets)) {
            numbersPerOneLotto.add(new Ticket(new LottoManualGenerator(numbers).generateNumbers()));
        }
        return numbersPerOneLotto;
    }

    private Ticket getAnswerTicket() {
        return new Ticket(InputView.getComparisonNumbers().stream()
            .map(Number::new)
            .collect(Collectors.toList())
        );
    }
}