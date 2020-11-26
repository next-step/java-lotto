package lotto;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.stream.IntStream;
import lotto.lottoexception.RemainBudgetException;

public class TicketPublisher {

  private TicketPublisher() {
  }

  static public LottoTicket publishTicket() {
    return LottoTicket.of(NumberPool.generateNumberBundle());
  }

  static public LottoTicket publishTicket(PublishStrategy publishStrategy) {
    return LottoTicket.of(NumberPool.generateNumberBundle(publishStrategy));
  }

  static public LottoTickets publishTickets(Budget budget) {
    int numPossibleTicket = budget.getNumPossibleLotto();

    if (numPossibleTicket < 1) {
      throw new RemainBudgetException();
    }

    return IntStream
        .range(0, numPossibleTicket)
        .mapToObj(x -> publishTicket())
        .collect(collectingAndThen(toList(), LottoTickets::of));
  }

  static public LottoTickets publishTickets(Budget budget, PublishStrategy publishStrategy) {
    int numPossibleTicket = budget.getNumPossibleLotto();

    if (numPossibleTicket < 1) {
      throw new RemainBudgetException();
    }

    return IntStream
        .range(0, numPossibleTicket)
        .mapToObj(x -> publishTicket(publishStrategy))
        .collect(collectingAndThen(toList(), LottoTickets::of));
  }

  static public LottoTicket publishTicket1() {
    return LottoTicket.of(NumberPool.generateNumberBundle1());
  }

  static public LottoTicket publishTicket1(PublishStrategy publishStrategy) {
    return LottoTicket.of(NumberPool.generateNumberBundle1(publishStrategy));
  }

  static public LottoTickets publishTickets1(Budget budget) {
    int numPossibleTicket = budget.getNumPossibleLotto();

    if (numPossibleTicket < 1) {
      throw new RemainBudgetException();
    }

    return IntStream
        .range(0, numPossibleTicket)
        .mapToObj(x -> publishTicket1())
        .collect(collectingAndThen(toList(), LottoTickets::of));
  }
}
