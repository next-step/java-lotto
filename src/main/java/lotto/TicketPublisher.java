package lotto;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.LottoGameConstant.AUTO;
import static lotto.LottoGameConstant.MANUAL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.dto.TicketPublisherDTO;
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

    if (numPossibleTicket < 0) {
      throw new RemainBudgetException();
    }

    this.publishingHistory.put(AUTO, this.publishingHistory.get(AUTO) + numPossibleTicket);

    return IntStream
        .range(0, numPossibleTicket)
        .mapToObj(x -> publishAutoTicket())
        .collect(collectingAndThen(toList(), LottoTickets::of));
  }

  public LottoTickets publishManualTickets(List<LottoNumberBundle> bundles, Budget budget) {
    int numPossibleTicket = budget.getNumPossibleBuyingTicket();

    if (numPossibleTicket < bundles.size()) {
      throw new RemainBudgetException();
    }

    budget.reduceRemain(bundles.size());

    this.publishingHistory.put(MANUAL, this.publishingHistory.get(MANUAL) + bundles.size());

    return bundles.stream()
        .map(LottoTicket::of)
        .collect(collectingAndThen(toList(), LottoTickets::of));
  }

  public TicketPublisherDTO exportData() {
    return new TicketPublisherDTO(new HashMap<>(this.publishingHistory));
  }
}
