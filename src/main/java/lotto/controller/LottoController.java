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
        final List<List<Number>> manualTicketNumbers = getManualTicketNumbers(manualLottoTickets);

        TicketMachine machine = new TicketMachine(amount, manualTicketNumbers);
        Tickets tickets = machine.purchase();

        OutputView.printBuyingTickets(manualTicketNumbers.size(), amount.getAutoTickets(manualTicketNumbers.size()));

        showTickets(tickets);
        showResult(tickets, amount);
    }

    private void showTickets(final Tickets tickets) {
        tickets.getEachTicketNumbers().forEach(OutputView::printLottoTicket);
    }

    private void showResult(final Tickets tickets, final Amount amount) {
        final Ticket answerTicket = getAnswerTicket();
        final Number bonusNumber = new Number(InputView.getBonus());

        Answer answer = new Answer(answerTicket, bonusNumber);
        Map<Rank, Integer> prizeMap = answer.getComparisonPrizeMap(tickets);

        OutputView.printStatistics(prizeMap);
        OutputView.printResult(new PrizeRatio().calculateRatio(amount, prizeMap));
    }

    private List<List<Number>> getManualTicketNumbers(final int manualTickets) {
        List<List<Number>> numbersPerOneLotto = new ArrayList<>();
        for (List<Integer> numbers : InputView.getManualLottoNumbers(manualTickets)) {
            numbersPerOneLotto.add(
                numbers.stream().map(Number::new).collect(Collectors.toList())
            );
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