package lotto;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.LottoGameConstant.AUTO;
import static lotto.LottoGameConstant.MANUAL;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.lottoexception.RemainBudgetException;

public class TicketPublisher {

  Map<Integer, Integer> publishingHistory;

  public TicketPublisher() {
    this.publishingHistory = new HashMap<>();
    this.publishingHistory.put(MANUAL, 0);
    this.publishingHistory.put(AUTO, 0);
  }

  public LottoTicket publishAutoTicket() {
    return LottoTicket.of(NumberPool.generateNumberBundle());
  }

  public LottoTicket publishAutoTicket(PublishStrategy publishStrategy) {
    return LottoTicket.of(NumberPool.generateNumberBundle(publishStrategy));
  }

  public LottoTickets publishAutoTickets(Budget budget) {
    int numPossibleTicket = budget.getNumPossibleBuyingTicket();

    if (numPossibleTicket < 1) {
      throw new RemainBudgetException();
    }

    this.publishingHistory.put(AUTO, this.publishingHistory.get(AUTO) + numPossibleTicket);

    return IntStream
        .range(0, numPossibleTicket)
        .mapToObj(x -> publishAutoTicket())
        .collect(collectingAndThen(toList(), LottoTickets::of));
  }
}
